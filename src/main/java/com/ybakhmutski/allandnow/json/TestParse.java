package com.ybakhmutski.allandnow.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by Yury_Bakhmutski on 6/21/2017.
 */
public class TestParse {
    public static void main(String[] args) throws ParseException {
        theMethod();
    }

    private static void theMethod() throws ParseException {
        String input = "\"User-agent\": HTTPTool/1.0, " +
                "Date: Wed, 21 Jun 2017 09:13:50 GMT, Transfer-encoding: chunked, " +
                "Set-cookie: cookie0=value0; Max-Age=3600, " +
                "Set-cookie: cookie1=value1; HttpOnly, " +
                "Set-cookie: cookie2=value2; Secure";
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse( input );
        System.out.println(json.toString());
    }
}
