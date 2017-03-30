package com.ybakhmutski.allandnow.exceptions;

/**
 * Created by Yury_Bakhmutski on 2/2/2017.
 */
public class MessagesTest {

    public static void main(String[] args) {
        try {

            parenMethod();
        } catch (Exception e){
            //System.err.println(e.printStackTrace());
        }
    }

    private static void parenMethod() {
        childMethod();
    }

    private static void childMethod() {
        throw new RuntimeException("The Message");
    }

}
