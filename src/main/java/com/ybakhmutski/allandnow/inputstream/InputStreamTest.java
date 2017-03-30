package com.ybakhmutski.allandnow.inputstream;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Created by Yury_Bakhmutski on 2/3/2017.
 */
public class InputStreamTest {
    public static void main(String[] args) {
        InputStream is = new ByteArrayInputStream(Charset.forName("UTF-16").encode(myString()).array());
    }

    private static CharBuffer myString() {
        return null;
    }
}
