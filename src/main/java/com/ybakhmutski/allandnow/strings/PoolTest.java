package com.epam.allandnow.strings;

public class PoolTest {
  public static void main( String[] args ) {
    String s1 = "He";
    String s2 = "H" + ( System.currentTimeMillis() > 0 ? "e" : "1" );
    String s3 = s2.intern();
    System.out.println( s1 == s2 );
    System.out.println( s1 == s3 );
    System.out.println( s2 == s3 );
    System.out.println( s1 == s1.intern() );
    
  }
}
