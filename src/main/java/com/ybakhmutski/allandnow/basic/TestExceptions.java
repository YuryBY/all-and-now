package com.ybakhmutski.allandnow.basic;

/**
 * Created by Yury_Bakhmutski on 6/16/2017.
 */
public class TestExceptions {
    public static void main(String[] args) {
        String result = theMethod();
        System.out.println(result);
    }

    private static String theMethod() {
        try {
            throw new Exception();
        } catch (Exception e) {
            // returning only first catch but not last which is in return!!!!!
            // System.out.println("catch");// this catch will show up
            return "catch";
        } finally {
            return "finally";
        }
    }
}
