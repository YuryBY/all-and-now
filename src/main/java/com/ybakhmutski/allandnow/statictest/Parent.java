package com.ybakhmutski.allandnow.statictest;

/**
 * Created by Yury_Bakhmutski on 2/1/2017.
 */
public class Parent {

    protected static String name = initName();

    private static String initName() {
        return "parent_name";
    }


}
