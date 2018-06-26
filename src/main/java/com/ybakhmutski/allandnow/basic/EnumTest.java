package com.ybakhmutski.allandnow.basic;

/**
 * Created by Yury_Bakhmutski on 1/19/2018.
 */
public class EnumTest {

    public static void main(String[] args) {
        System.out.println(TrafficLight.valueOf("AMBER"));
        for (TrafficLight light : TrafficLight.values()) {
            System.out.printf("%s: %d seconds\n", light, light.getSeconds());
        }
    }


    enum TrafficLight {
        RED(30), AMBER(10), GREEN(30);  // Named constants

        private final int seconds;      // Private variable

        TrafficLight(int seconds) {     // Constructor
            this.seconds = seconds;
        }

        int getSeconds() {              // Getter
            return seconds;
        }
    }
}
