package com.epam.allandnow.strings;

public class SomeMethodsTest {
  public static void main( String[] args ) {
    toReferences();
  }

  private static void toReferences() {
    String a = "a";
    String b = "b";
    System.out.println( "1: a==b " + ( a == b ) );
    b = a;
    System.out.println( "2: a==b " + ( a == b ) );
    b = new String( a );
    System.out.println( "3: a==b " + ( a == b ) );
    b.intern();
    System.out.println( "4: a==b " + ( a == b ) );
    b = "a".intern();
    System.out.println( "5: a==b " + ( a == b ) );
    b.intern();
    System.out.println( "6: a==b " + ( a == b ) );
  }
}
