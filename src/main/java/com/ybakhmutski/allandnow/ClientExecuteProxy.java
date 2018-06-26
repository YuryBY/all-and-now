package com.ybakhmutski.allandnow;
/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * How to send a request via proxy.
 *
 * @since 4.0
 */
public class ClientExecuteProxy {

    public static void main(String[] args)throws Exception {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials( "admin", "password" );
        provider.setCredentials( AuthScope.ANY, credentials );

        CloseableHttpClient httpclient=getCloseableHttpClient(provider);
        //CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
//            HttpHost target = new HttpHost("httpbin.org", 443, "https");
            String url = "http://127.0.0.1:8080/pentaho/kettle/registerTrans/?xml=Y";
            String xml = initXml();
            HttpHost target = new HttpHost("127.0.0.1", 8080, "http");
            //HttpHost proxy = new HttpHost("127.0.0.1", 8081, "http");

            RequestConfig config = RequestConfig.custom()
              //      .setProxy(proxy)
                    .build();
            HttpPost request = new HttpPost(url);
            request.setEntity(new ByteArrayEntity(xml.getBytes()));
            request.setConfig(config);

            System.out.println("Executing request " + request.getRequestLine() + " to " + target + " via " );



            CloseableHttpResponse response = httpclient.execute(target, request);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }

    private static CloseableHttpClient getCloseableHttpClient(CredentialsProvider provider) {
        CloseableHttpClient httpclient;
        httpclient = HttpClientBuilder
                .create()
                .setDefaultCredentialsProvider( provider )
                .build();
        return httpclient;
    }

    static String initXml(){
        return "<transformation_configuration>\n" +
                "<transformation>\n" +
                "  <info>\n" +
                "    <name>PDI_16601</name>\n" +
                "    <description/>\n" +
                "    <extended_description/>\n" +
                "    <trans_version/>\n" +
                "    <trans_type>Normal</trans_type>\n" +
                "    <directory>/</directory>\n" +
                "    <parameters>\n" +
                "    </parameters>\n" +
                "    <log>\n" +
                "      <trans-log-table>\n" +
                "        <connection/>\n" +
                "        <schema/>\n" +
                "        <table/>\n" +
                "        <size_limit_lines/>\n" +
                "        <interval/>\n" +
                "        <timeout_days/>\n" +
                "        <field>\n" +
                "          <id>ID_BATCH</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>ID_BATCH</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>CHANNEL_ID</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>CHANNEL_ID</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>TRANSNAME</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>TRANSNAME</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>STATUS</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>STATUS</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_READ</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_READ</name>\n" +
                "          <subject/>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_WRITTEN</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_WRITTEN</name>\n" +
                "          <subject/>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_UPDATED</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_UPDATED</name>\n" +
                "          <subject/>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_INPUT</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_INPUT</name>\n" +
                "          <subject/>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_OUTPUT</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_OUTPUT</name>\n" +
                "          <subject/>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_REJECTED</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_REJECTED</name>\n" +
                "          <subject/>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>ERRORS</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>ERRORS</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>STARTDATE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>STARTDATE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>ENDDATE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>ENDDATE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LOGDATE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LOGDATE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>DEPDATE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>DEPDATE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>REPLAYDATE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>REPLAYDATE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LOG_FIELD</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LOG_FIELD</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>EXECUTING_SERVER</id>\n" +
                "          <enabled>N</enabled>\n" +
                "          <name>EXECUTING_SERVER</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>EXECUTING_USER</id>\n" +
                "          <enabled>N</enabled>\n" +
                "          <name>EXECUTING_USER</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>CLIENT</id>\n" +
                "          <enabled>N</enabled>\n" +
                "          <name>CLIENT</name>\n" +
                "        </field>\n" +
                "      </trans-log-table>\n" +
                "      <perf-log-table>\n" +
                "        <connection/>\n" +
                "        <schema/>\n" +
                "        <table/>\n" +
                "        <interval/>\n" +
                "        <timeout_days/>\n" +
                "        <field>\n" +
                "          <id>ID_BATCH</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>ID_BATCH</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>SEQ_NR</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>SEQ_NR</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LOGDATE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LOGDATE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>TRANSNAME</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>TRANSNAME</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>STEPNAME</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>STEPNAME</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>STEP_COPY</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>STEP_COPY</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_READ</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_READ</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_WRITTEN</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_WRITTEN</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_UPDATED</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_UPDATED</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_INPUT</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_INPUT</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_OUTPUT</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_OUTPUT</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_REJECTED</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_REJECTED</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>ERRORS</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>ERRORS</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>INPUT_BUFFER_ROWS</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>INPUT_BUFFER_ROWS</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>OUTPUT_BUFFER_ROWS</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>OUTPUT_BUFFER_ROWS</name>\n" +
                "        </field>\n" +
                "      </perf-log-table>\n" +
                "      <channel-log-table>\n" +
                "        <connection/>\n" +
                "        <schema/>\n" +
                "        <table/>\n" +
                "        <timeout_days/>\n" +
                "        <field>\n" +
                "          <id>ID_BATCH</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>ID_BATCH</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>CHANNEL_ID</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>CHANNEL_ID</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LOG_DATE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LOG_DATE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LOGGING_OBJECT_TYPE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LOGGING_OBJECT_TYPE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>OBJECT_NAME</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>OBJECT_NAME</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>OBJECT_COPY</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>OBJECT_COPY</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>REPOSITORY_DIRECTORY</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>REPOSITORY_DIRECTORY</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>FILENAME</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>FILENAME</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>OBJECT_ID</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>OBJECT_ID</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>OBJECT_REVISION</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>OBJECT_REVISION</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>PARENT_CHANNEL_ID</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>PARENT_CHANNEL_ID</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>ROOT_CHANNEL_ID</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>ROOT_CHANNEL_ID</name>\n" +
                "        </field>\n" +
                "      </channel-log-table>\n" +
                "      <step-log-table>\n" +
                "        <connection/>\n" +
                "        <schema/>\n" +
                "        <table/>\n" +
                "        <timeout_days/>\n" +
                "        <field>\n" +
                "          <id>ID_BATCH</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>ID_BATCH</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>CHANNEL_ID</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>CHANNEL_ID</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LOG_DATE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LOG_DATE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>TRANSNAME</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>TRANSNAME</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>STEPNAME</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>STEPNAME</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>STEP_COPY</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>STEP_COPY</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_READ</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_READ</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_WRITTEN</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_WRITTEN</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_UPDATED</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_UPDATED</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_INPUT</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_INPUT</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_OUTPUT</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_OUTPUT</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LINES_REJECTED</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LINES_REJECTED</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>ERRORS</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>ERRORS</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LOG_FIELD</id>\n" +
                "          <enabled>N</enabled>\n" +
                "          <name>LOG_FIELD</name>\n" +
                "        </field>\n" +
                "      </step-log-table>\n" +
                "      <metrics-log-table>\n" +
                "        <connection/>\n" +
                "        <schema/>\n" +
                "        <table/>\n" +
                "        <timeout_days/>\n" +
                "        <field>\n" +
                "          <id>ID_BATCH</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>ID_BATCH</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>CHANNEL_ID</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>CHANNEL_ID</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>LOG_DATE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>LOG_DATE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>METRICS_DATE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>METRICS_DATE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>METRICS_CODE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>METRICS_CODE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>METRICS_DESCRIPTION</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>METRICS_DESCRIPTION</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>METRICS_SUBJECT</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>METRICS_SUBJECT</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>METRICS_TYPE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>METRICS_TYPE</name>\n" +
                "        </field>\n" +
                "        <field>\n" +
                "          <id>METRICS_VALUE</id>\n" +
                "          <enabled>Y</enabled>\n" +
                "          <name>METRICS_VALUE</name>\n" +
                "        </field>\n" +
                "      </metrics-log-table>\n" +
                "    </log>\n" +
                "    <maxdate>\n" +
                "      <connection/>\n" +
                "      <table/>\n" +
                "      <field/>\n" +
                "      <offset>0.0</offset>\n" +
                "      <maxdiff>0.0</maxdiff>\n" +
                "    </maxdate>\n" +
                "    <size_rowset>10000</size_rowset>\n" +
                "    <sleep_time_empty>50</sleep_time_empty>\n" +
                "    <sleep_time_full>50</sleep_time_full>\n" +
                "    <unique_connections>N</unique_connections>\n" +
                "    <feedback_shown>Y</feedback_shown>\n" +
                "    <feedback_size>50000</feedback_size>\n" +
                "    <using_thread_priorities>Y</using_thread_priorities>\n" +
                "    <shared_objects_file/>\n" +
                "    <capture_step_performance>N</capture_step_performance>\n" +
                "    <step_performance_capturing_delay>1000</step_performance_capturing_delay>\n" +
                "    <step_performance_capturing_size_limit>100</step_performance_capturing_size_limit>\n" +
                "    <dependencies>\n" +
                "    </dependencies>\n" +
                "    <partitionschemas>\n" +
                "    </partitionschemas>\n" +
                "    <slaveservers>\n" +
                "      <slaveserver>\n" +
                "        <name>localhost_8080</name>\n" +
                "        <hostname>localhost</hostname>\n" +
                "        <port>8080</port>\n" +
                "        <webAppName>pentaho</webAppName>\n" +
                "        <username>admin</username>\n" +
                "        <password>Encrypted 2be98afc86aa7f2e4bb18bd63c99dbdde</password>\n" +
                "        <proxy_hostname>127.0.0.1</proxy_hostname>\n" +
                "        <proxy_port>8081</proxy_port>\n" +
                "        <non_proxy_hosts/>\n" +
                "        <master>N</master>\n" +
                "        <sslMode>N</sslMode>\n" +
                "      </slaveserver>\n" +
                "    </slaveservers>\n" +
                "    <clusterschemas>\n" +
                "    </clusterschemas>\n" +
                "    <created_user>-</created_user>\n" +
                "    <created_date>2017/11/17 12:38:59.754</created_date>\n" +
                "    <modified_user>-</modified_user>\n" +
                "    <modified_date>2017/11/17 12:38:59.754</modified_date>\n" +
                "    <key_for_session_key>H4sIAAAAAAAAAAMAAAAAAAAAAAA=</key_for_session_key>\n" +
                "    <is_key_private>N</is_key_private>\n" +
                "  </info>\n" +
                "  <notepads>\n" +
                "  </notepads>\n" +
                "  <order>\n" +
                "    <hop>\n" +
                "      <from>Generate Rows</from>\n" +
                "      <to>Text file output</to>\n" +
                "      <enabled>Y</enabled>\n" +
                "    </hop>\n" +
                "  </order>\n" +
                "  <step>\n" +
                "    <name>Generate Rows</name>\n" +
                "    <type>RowGenerator</type>\n" +
                "    <description/>\n" +
                "    <distribute>Y</distribute>\n" +
                "    <custom_distribution/>\n" +
                "    <copies>1</copies>\n" +
                "    <partitioning>\n" +
                "      <method>none</method>\n" +
                "      <schema_name/>\n" +
                "    </partitioning>\n" +
                "    <fields>\n" +
                "      <field>\n" +
                "        <name>a</name>\n" +
                "        <type>Integer</type>\n" +
                "        <format/>\n" +
                "        <currency/>\n" +
                "        <decimal/>\n" +
                "        <group/>\n" +
                "        <nullif>1</nullif>\n" +
                "        <length>-1</length>\n" +
                "        <precision>-1</precision>\n" +
                "        <set_empty_string>N</set_empty_string>\n" +
                "      </field>\n" +
                "      <field>\n" +
                "        <name>b</name>\n" +
                "        <type>String</type>\n" +
                "        <format/>\n" +
                "        <currency/>\n" +
                "        <decimal/>\n" +
                "        <group/>\n" +
                "        <nullif>string</nullif>\n" +
                "        <length>-1</length>\n" +
                "        <precision>-1</precision>\n" +
                "        <set_empty_string>N</set_empty_string>\n" +
                "      </field>\n" +
                "    </fields>\n" +
                "    <limit>10</limit>\n" +
                "    <never_ending>N</never_ending>\n" +
                "    <interval_in_ms>5000</interval_in_ms>\n" +
                "    <row_time_field>now</row_time_field>\n" +
                "    <last_time_field>FiveSecondsAgo</last_time_field>\n" +
                "    <cluster_schema/>\n" +
                "    <remotesteps>\n" +
                "      <input>\n" +
                "      </input>\n" +
                "      <output>\n" +
                "      </output>\n" +
                "    </remotesteps>\n" +
                "    <GUI>\n" +
                "      <xloc>320</xloc>\n" +
                "      <yloc>224</yloc>\n" +
                "      <draw>Y</draw>\n" +
                "    </GUI>\n" +
                "  </step>\n" +
                "  <step>\n" +
                "    <name>Text file output</name>\n" +
                "    <type>TextFileOutput</type>\n" +
                "    <description/>\n" +
                "    <distribute>Y</distribute>\n" +
                "    <custom_distribution/>\n" +
                "    <copies>1</copies>\n" +
                "    <partitioning>\n" +
                "      <method>none</method>\n" +
                "      <schema_name/>\n" +
                "    </partitioning>\n" +
                "    <separator>;</separator>\n" +
                "    <enclosure>\"</enclosure>\n" +
                "    <enclosure_forced>N</enclosure_forced>\n" +
                "    <enclosure_fix_disabled>N</enclosure_fix_disabled>\n" +
                "    <header>Y</header>\n" +
                "    <footer>N</footer>\n" +
                "    <format>DOS</format>\n" +
                "    <compression>None</compression>\n" +
                "    <encoding/>\n" +
                "    <endedLine/>\n" +
                "    <fileNameInField>N</fileNameInField>\n" +
                "    <fileNameField/>\n" +
                "    <create_parent_folder>Y</create_parent_folder>\n" +
                "    <file>\n" +
                "      <name>${file_path}</name>\n" +
                "      <is_command>N</is_command>\n" +
                "      <servlet_output>N</servlet_output>\n" +
                "      <do_not_open_new_file_init>N</do_not_open_new_file_init>\n" +
                "      <extention>txt</extention>\n" +
                "      <append>N</append>\n" +
                "      <split>N</split>\n" +
                "      <haspartno>N</haspartno>\n" +
                "      <add_date>N</add_date>\n" +
                "      <add_time>N</add_time>\n" +
                "      <SpecifyFormat>N</SpecifyFormat>\n" +
                "      <date_time_format/>\n" +
                "      <add_to_result_filenames>Y</add_to_result_filenames>\n" +
                "      <pad>N</pad>\n" +
                "      <fast_dump>N</fast_dump>\n" +
                "      <splitevery>0</splitevery>\n" +
                "    </file>\n" +
                "    <fields>\n" +
                "    </fields>\n" +
                "    <cluster_schema/>\n" +
                "    <remotesteps>\n" +
                "      <input>\n" +
                "      </input>\n" +
                "      <output>\n" +
                "      </output>\n" +
                "    </remotesteps>\n" +
                "    <GUI>\n" +
                "      <xloc>752</xloc>\n" +
                "      <yloc>336</yloc>\n" +
                "      <draw>Y</draw>\n" +
                "    </GUI>\n" +
                "  </step>\n" +
                "  <step_error_handling>\n" +
                "  </step_error_handling>\n" +
                "  <slave-step-copy-partition-distribution>\n" +
                "  </slave-step-copy-partition-distribution>\n" +
                "  <slave_transformation>N</slave_transformation>\n" +
                "</transformation>\n" +
                "  <transformation_execution_configuration>\n" +
                "    <exec_local>N</exec_local>\n" +
                "    <exec_remote>Y</exec_remote>\n" +
                "          <slaveserver>\n" +
                "        <name>localhost_8080</name>\n" +
                "        <hostname>localhost</hostname>\n" +
                "        <port>8080</port>\n" +
                "        <webAppName>pentaho</webAppName>\n" +
                "        <username>admin</username>\n" +
                "<password>Encrypted 2be98afc86aa7f2e4bb18bd63c99dbdde</password>        <proxy_hostname>127.0.0.1</proxy_hostname>\n" +
                "        <proxy_port>8081</proxy_port>\n" +
                "        <non_proxy_hosts/>\n" +
                "        <master>N</master>\n" +
                "        <sslMode>N</sslMode>      </slaveserver>\n" +
                "\n" +
                "    <pass_export>N</pass_export>\n" +
                "    <exec_cluster>N</exec_cluster>\n" +
                "    <cluster_post>Y</cluster_post>\n" +
                "    <cluster_prepare>Y</cluster_prepare>\n" +
                "    <cluster_start>Y</cluster_start>\n" +
                "    <cluster_show_trans>N</cluster_show_trans>\n" +
                "    <parameters>\n" +
                "    </parameters>\n" +
                "    <variables>\n" +
                "    <variable><name>Internal.Entry.Current.Directory</name><value>file:///E:/cur/PDI-16601</value></variable>\n" +
                "    <variable><name>Internal.Job.Filename.Directory</name><value>Parent Job File Directory</value></variable>\n" +
                "    <variable><name>Internal.Job.Filename.Name</name><value>Parent Job Filename</value></variable>\n" +
                "    <variable><name>Internal.Job.Name</name><value>Parent Job Name</value></variable>\n" +
                "    <variable><name>Internal.Job.Repository.Directory</name><value>Parent Job Repository Directory</value></variable>\n" +
                "    <variable><name>Internal.Job.Run.AttemptNr</name><value/></variable>\n" +
                "    <variable><name>Internal.Job.Run.ID</name><value/></variable>\n" +
                "    <variable><name>Internal.Transformation.Filename.Directory</name><value>file:///E:/cur/PDI-16601</value></variable>\n" +
                "    <variable><name>Internal.Transformation.Filename.Name</name><value>PDI_16601.ktr</value></variable>\n" +
                "    <variable><name>Internal.Transformation.Name</name><value>PDI_16601</value></variable>\n" +
                "    <variable><name>Internal.Transformation.Repository.Directory</name><value>file:///E:/cur/PDI-16601</value></variable>\n" +
                "    <variable><name>file_path</name><value/></variable>\n" +
                "    </variables>\n" +
                "    <arguments>\n" +
                "    </arguments>\n" +
                "    <replay_date/>\n" +
                "    <safe_mode>N</safe_mode>\n" +
                "    <log_level>Basic</log_level>\n" +
                "    <log_file>N</log_file>\n" +
                "    <log_filename/>\n" +
                "    <log_file_append>N</log_file_append>\n" +
                "    <create_parent_folder>N</create_parent_folder>\n" +
                "    <clear_log>Y</clear_log>\n" +
                "    <gather_metrics>Y</gather_metrics>\n" +
                "    <show_subcomponents>Y</show_subcomponents>\n" +
                "    <run_configuration>Configuration 1</run_configuration>\n" +
                "</transformation_execution_configuration>\n" +
                "</transformation_configuration>\n";
    }

}
