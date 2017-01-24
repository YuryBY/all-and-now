package com.epam.allandnow.basic;

public class InnerClassesTester {

  int b;
  static int a;

  public static class NestedClass {
  }

  public class InnerClass {
  }
}

class Test {
  public static void main( String[] args ) {
    new InnerClassesTester.NestedClass();
    // new InnerClassesTester.InnerClass(); - not compiled
    new InnerClassesTester().new InnerClass();
    InnerClassesTester.InnerClass innerClass = new InnerClassesTester().new InnerClass();
  }
}
