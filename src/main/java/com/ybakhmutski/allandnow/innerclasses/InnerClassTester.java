package com.epam.allandnow.innerclasses;

/**
 * Created by Yury_Bakhmutski on 3/16/2016.
 */
public class InnerClassTester {

  public static void main( String[] args ) {
    method();
  }

  private static Runnable method() {
    // int s = 1; - non compile
    final int s = 1;
    Runnable r = new Runnable() {
      @Override
      public void run() {
        System.out.println( s );
      }
    };
    // non compile s = 2;
    return r;
  }

  void method2() {
    method().run();
  }

}
