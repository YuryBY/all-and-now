package com.ybakhmutski.allandnow.strings;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Yury_Bakhmutski on 6/14/2017.
 */
public class ApacheUtilsTest {
    public static void main(String[] args) {

        String empty="";
        String blank="  ";

        System.out.println(StringUtils.isNotEmpty( empty ));
        System.out.println(StringUtils.isNotEmpty( blank ));

        System.out.println(StringUtils.isBlank(empty));
        System.out.println(StringUtils.isBlank(blank));
    }
}
