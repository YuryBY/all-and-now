package com.ybakhmutski.allandnow.multithreading;

/**
 * Created by Yury_Bakhmutski on 1/25/2017.
 */
public class JavaBasicsL10 {

    public static void main(String[] args) {

        threadMethods();

    }

    private static void threadMethods() {

        for (int i = 0; i < 10; i++) {
            TestThread testThread = new TestThread();
            testThread.start();
         //   testThread.start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new TestRunnable()).start();
            //   testThread.start();
        }

    }

    private static class TestThread extends Thread {

        @Override
        public void run() {
            System.out.println("Test Thread " + getId());
        }
    }

    private static class TestRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Test Runnable " + Thread.currentThread().getId());
        }
    }

}
