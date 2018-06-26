package com.ybakhmutski.allandnow.multithreading.synchronyzedtest;

/**
 * Created by Yury_Bakhmutski on 12/4/2017.
 */
public class ExampleRunner {


    public static void main(String[] args) {
        final Service service = new Service();
        UserData userData = service.getUserData();
        userData.increase();
        System.out.println(userData);

        new Thread(){
            public void run() {
                service.getUserData().increase();
            }}.start();

        System.out.println(userData);

    }
}
