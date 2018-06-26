package com.ybakhmutski.allandnow.basic;

import java.nio.charset.Charset;

/**
 * Created by Yury_Bakhmutski on 6/20/2017.
 */
public class TestCharset {
    public static void main(String[] args) {
        String in = "Content-Type: text/plain; charset=utf-8";
        Charset UNICODE_CHARSET = Charset.forName("UTF-8");
        System.out.println(UNICODE_CHARSET.name());

    }
}
