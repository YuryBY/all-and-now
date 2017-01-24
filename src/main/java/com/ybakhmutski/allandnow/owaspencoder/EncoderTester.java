package com.ybakhmutski.allandnow.owaspencoder;

import org.owasp.encoder.Encode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Yury_Bakhmutski on 1/11/2017.
 */
public class EncoderTester {

    public static void main(String[] args) throws MalformedURLException {
        theMethod();
    }

    static void theMethod() throws MalformedURLException {

      String mobileRedirect
          = "content/pentaho-mobile/resources/index.html";
      String requestedURL
          = "http://10.6.117.14:8080/pentaho/Home?name=mobile_544&startup-url=%2Fpentaho%2Fapi%2Frepos%2F%253Ahome%253Aadmin%253Amobile_544.xanalyzer%2Feditor";

      if (mobileRedirect != null) {
        final Map<String, String> queryPairs = new LinkedHashMap<String, String>();
        URL url = new URL( requestedURL );
        String[] pairs = url.getQuery().split( "&" );
        for ( String pair : pairs ){
          int delimiter = pair.indexOf( "=" );
          queryPairs.put( Encode.forJavaScript( pair.substring( 0, delimiter ) ),  Encode.forJavaScript( pair.substring( delimiter + 1 ) )); }
          if ( queryPairs.size() > 0 ) {
            System.out.println("!!!-9: " + queryPairs);
            mobileRedirect += "?";
            Iterator it = queryPairs.entrySet().iterator();
            while ( it.hasNext() ) {
              Map.Entry entry = (Map.Entry) it.next();
              mobileRedirect += entry.getKey() + "=" + entry.getValue();
              it.remove();
                if ( it.hasNext() ){
                  mobileRedirect += "&";
                }
              }
            System.out.println("mobileRedirect-12:: "+mobileRedirect);
          }
      }

    }


    /*static void theMethod() throws MalformedURLException {

      String mobileRedirect
          = "content/pentaho-mobile/resources/index.html";
      String requestedURL
          = "http://10.6.117.14:8080/pentaho/Home?name=mobile_544&startup-url=%2Fpentaho%2Fapi%2Frepos%2F%253Ahome%253Aadmin%253Amobile_544.xanalyzer%2Feditor";

      if (mobileRedirect != null) {
        final Map<String, String> queryPairs = new LinkedHashMap<String, String>();
            URL url = new URL( requestedURL );
            System.out.println("url: " + url);
            String[] pairs = url.getQuery().split( "&" );
            for ( String pair : pairs ){
                int idx = pair.indexOf( "=" );
                System.out.println("key-pair.substring( 0, idx ): " + pair.substring( 0, idx ));
                System.out.println("value-pair.substring( idx + 1 ): " + pair.substring( idx + 1 ));
                queryPairs.put( Encode.forJavaScript( pair.substring( 0, idx ) ),  Encode.forJavaScript( pair.substring( idx + 1 ) )); }
            if ( queryPairs.size() > 0 ) {
                System.out.println("!!!-9: " + queryPairs);
                mobileRedirect += "?";
                Iterator it = queryPairs.entrySet().iterator();
                while ( it.hasNext() ) {
                    Map.Entry entry = (Map.Entry) it.next();
                    mobileRedirect += entry.getKey() + "=" + entry.getValue();
                    it.remove();
                    if ( it.hasNext() ){
                        mobileRedirect += "&";
                        System.out.println("mobileRedirect-11:: "+mobileRedirect);
                    }
                }
                System.out.println("mobileRedirect-12:: "+mobileRedirect);
            }
        }

    }*/

}
