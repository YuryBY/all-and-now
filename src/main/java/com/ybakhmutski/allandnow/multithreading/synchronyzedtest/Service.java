package com.ybakhmutski.allandnow.multithreading.synchronyzedtest;

/**
 * Created by Yury_Bakhmutski on 12/4/2017.
 */
public class Service {

    UserData userData;

    synchronized UserData getUserData() {
        if (userData == null) {
            userData = new UserData();
        }
        return userData;
    }

    void ShowUserData(){
        userData.toString();
    }

}
