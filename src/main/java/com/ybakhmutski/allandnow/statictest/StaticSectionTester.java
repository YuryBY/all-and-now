package com.ybakhmutski.allandnow.statictest;

/**
 * Created by Yury_Bakhmutski on 2/1/2017.
 */
public class StaticSectionTester {

    public static void main(String[] args) {
        new Child();
        System.out.println(Child.name);
    }

}
