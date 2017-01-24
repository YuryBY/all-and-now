package com.epam.allandnow.basic;

public class A {

  {
    // System.out.println( "init section2 - 1 " + x );
    x = 1;
    // System.out.println( "init section2 - 2 " + x );
  }
  int x = f();
  {
    System.out.println( "init section2 - 1 " + x );
    x = 3;
    System.out.println( "init section2 - 2 " + x );
  }

  A() {
    System.out.println( "contructor - 1 " + x );
    x = 4;
    System.out.println( "contructor - 2 " + x );
  }

  private int f() {
    System.out.println( "method - 1 " + x );
    x = 2;
    System.out.println( "method - 2 " + x );
    return 0;
  }

}
