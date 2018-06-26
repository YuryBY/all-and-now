package com.ybakhmutski.allandnow.basic;

/**
 * Created by Yury_Bakhmutski on 4/5/2017.
 */
public class IncrementTest {
    public static void main(String[] args) {

        int i = 1;
        for (int j = 0; j < 5; j++) {
            method(i++);
        }
        System.out.println(IncrementTest.class);
    }

    private static void method(int i) {
        System.out.println(i);
    }


}
