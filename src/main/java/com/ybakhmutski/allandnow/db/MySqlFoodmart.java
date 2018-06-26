package com.ybakhmutski.allandnow.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yury_Bakhmutski on 7/7/2017.
 */
public class MySqlFoodmart {
    public static void main(String[] argv) throws SQLException {

        String dmxUrl = "jdbc:mysql://10.177.176.206/foodmart";
        String dmzUser = "foodmart";
        String dmzPassword = "pentaho06";

        String localUrl = "jdbc:mysql://localhost/sample";
        String localUser = "root";
        String localPassword = "root";

        runTestQueries(localUrl, localUser, localPassword);

    }

    private static void runTestQueries(String url, String user, String password) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Driver?");
            e.printStackTrace();
            return;
        }
        System.out.println("Registered!");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://10.177.177.212/foodmart?user=foodmart&password=pentaho06");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        ResultSet rs = connection.getMetaData().getCatalogs();

        while (rs.next()) {
            System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT") );
        }

        if (connection != null) {
            System.out.println("connection was created");
        } else {
            System.out.println("Failed to make connection");
        }
        Statement statement = connection.createStatement();
        String sql = " show tables";
        //String sql = "select * from  store where store_country='Mexico'";
        /*String sql =
                "select * from " +
                        "(select \"store\".\"store_country\" as \"c0\", " +
                        "\"store\".\"store_state\" as \"c1\", " +
                        "\"store\".\"store_city\" as \"c2\", " +
                        "\"time_by_day\".\"the_year\" as \"c3\", " +
                        "\"time_by_day\".\"the_year\" as \"c4\" " +
                        "from " +
                        "\"store\" as \"store\", " +
                        "\"sales_fact_1997\" as \"sales_fact_1997\", " +
                        "\"time_by_day\" as \"time_by_day\" " +
                        "where " +
                        "\"sales_fact_1997\".\"store_id\" = \"store\".\"store_id\" and \"sales_fact_1997\".\"time_id\" = \"time_by_day\".\"time_id\" " +
                        "group by " +
                        "\"store\".\"store_country\", \"store\".\"store_state\", \"store\".\"store_city\", \"time_by_day\".\"the_year\" union select " +
                        "\"store\".\"store_country\" as \"c0\", \"store\".\"store_state\" as \"c1\", \"store\".\"store_city\" as \"c2\", \"time_by_day\".\"the_year\" as \"c3\", " +
                        "\"time_by_day\".\"the_year\" as \"c4\" from \"store\" as \"store\", \"inventory_fact_1997\" as \"inventory_fact_1997\", " +
                        "\"time_by_day\" as \"time_by_day\" where \"inventory_fact_1997\".\"store_id\" = \"store\".\"store_id\" and \"inventory_fact_1997\".\"time_id\" = " +
                        "\"time_by_day\".\"time_id\" group by \"store\".\"store_country\", \"store\".\"store_state\", \"store\".\"store_city\", \"time_by_day\".\"the_year\") as " +
                        "\"unionQuery\" " +
                        "order by " +
                        "1  ASC, " +
                        "2 ASC, " +
                        "3 ASC, " +
                        "4 ASC, " +
                        "5 ASC";*/
                /*"CASE WHEN \"c0\" IS NULL THEN 1 ELSE 0 END, \"c0\"  ASC, " +
                "CASE WHEN \"c1\" IS NULL THEN 1 ELSE 0 END, \"c1\" ASC, " +
                "CASE WHEN \"c2\" IS NULL THEN 1 ELSE 0 END, \"c2\" ASC, " +
                "CASE WHEN \"c3\" IS NULL THEN 1 ELSE 0 END, \"c3\" ASC, " +
                "CASE WHEN \"c4\" IS NULL THEN 1 ELSE 0 END, \"c4\" ASC";*/
        /*"CASE WHEN 1 IS NULL THEN 1 ELSE 0 END";*//* +
                "CASE WHEN \"2\" IS NULL THEN 1 ELSE 0 END, \"2\" ASC, " +
                "CASE WHEN \"3\" IS NULL THEN 1 ELSE 0 END, \"3\" ASC, " +
                "CASE WHEN \"4\" IS NULL THEN 1 ELSE 0 END, \"4\" ASC, " +
                "CASE WHEN \"5\" IS NULL THEN 1 ELSE 0 END, \"5\" ASC";*/
        ResultSet resultSet = statement.executeQuery(sql);
        //System.out.println(resultSet.getMetaData().getColumnCount());
        List columnByColumn = new ArrayList(5);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.print(resultSet.getString(i) + " "); //Print one element of a row
            }
            System.out.print(" | \n");
            //System.out.println("---------");
        }
    }
}
