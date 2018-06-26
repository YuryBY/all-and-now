package com.ybakhmutski.allandnow.resourcebundletest;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Yury_Bakhmutski on 9/25/2017.
 */
public class Tester {

    public static void main(String[] args) {

        // en_US
        System.out.println("Current Locale: " + Locale.getDefault());
        ResourceBundle mybundle = ResourceBundle.getBundle("resources");

        // read MyLabels_en_US.properties
        //System.out.println("Say how are you in US English: " + mybundle.getString("XmiParser.ERROR_0012_INVALID_CATEGORY_ID"));
        String key = "XmiParser.ERROR_0012_INVALID_CATEGORY_ID";
        System.out.println(Messages.getErrorString(key, 1, "{}"  ));

//        Locale.setDefault(new Locale("ms", "MY"));

        // read MyLabels_ms_MY.properties
        /*System.out.println("Current Locale: " + Locale.getDefault());
        mybundle = ResourceBundle.getBundle("resources");
        System.out.println("Say how are you in Malaysian Malaya language: " + mybundle.getString("XmiParser.ERROR_0012_INVALID_CATEGORY_ID"));*/

    }

}