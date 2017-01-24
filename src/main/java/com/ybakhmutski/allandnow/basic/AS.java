package com.epam.allandnow.basic;

/**
 * Created by Yury_Bakhmutski on 1/13/2017.
 */
public class AS {
    public static void main(String[] args) {
        String in = "content/pentaho-mobile/resources/index.html\n" +
                "?\n" +
                "name=mobile_544&startup\\-url=%2Fpentaho%2Fapi%2Frepos%2F%253Ahome%253Aadmin%253Amobile_544.xanalyzer%2Feditor\n" +
                "?param=Japan";

        int i = in.indexOf("?");
        String substring = in.substring(i + 1);
        System.out.println(in.substring(i+1));


    }
}
