package com.ybakhmutski.allandnow.multithreading.synchronyzedtest;

/**
 * Created by Yury_Bakhmutski on 12/4/2017.
 */
public class UserData {

    String name = "bean";
    int count = 0;

    public String getName() {
        return name;
    }

    void increase(){
        count++;
    }

    public int getCount() {
        return count;
    }

    /*@Override
    public String toString() {
        return name + ": " + count;
    }*/
}
