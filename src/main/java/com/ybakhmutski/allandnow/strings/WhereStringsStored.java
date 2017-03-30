package com.epam.allandnow.strings;

/**
 * Created by Yury_Bakhmutski on 3/25/2016.
 */
public class WhereStringsStored {
  public static void main( String[] args ) {

    //checkSameStringsEquality();
    //checkSameInternStringsEquality();
    //netExample();
    internPermGenTest();

  }

  private static void internPermGenTest() {
    for ( int i = 0; i < 100000; i++ ) {
     String string = new String (String.valueOf( 1 )).intern();
    }
    for ( int i = 0; i < 100000; i++ ) {
      String string = new String (String.valueOf( 2 )).intern();
    }
    for ( int i = 0; i < 100000; i++ ) {
      String string = new String (String.valueOf( 3 )).intern();
    }
    Thread thread = new Thread( new Runnable() {
      @Override
      public void run() {
      while ( true );
      }
    } );
    thread.start();
    try {
      Thread.currentThread().join();
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }
  }

  private static void checkSameInternStringsEquality() {
    String first = "a".intern();
    String second = "a".intern();
    // is not enough first.intern();
    //is not enough second.intern();
    System.out.println( "first.equals( second ): " + first.equals( second ) );
    System.out.println( "first==second: " + (first == second) );
  }

  private static void checkSameStringsEquality() {
    String first = "a";
    String second = "a";
    System.out.println( "first.equals( second ): " + first.equals( second ) );
    System.out.println( "first==second: " + (first == second) );
  }

  public static void netExample() {

    String str1 = "JavaCodeGeeks";
    String str2 = "JavaCodeGeeks";
    String str3 = "JavaCodeGeeks".intern();
    String str4 = new String( "JavaCodeGeeks" );
    String str5 = new String( "JavaCodeGeeks" ).intern();

    System.out.println( "Are str1 and str2 the same: " + ( str1 == str2 ) );
    System.out.println( "Are str1 and str3 the same: " + ( str1 == str3 ) );
    System.out.println(
        "Are str1 and str4 the same: " + ( str1 == str4 ) ); //this should be "false" because str4 is not interned
    System.out
        .println( "Are str1 and str4.intern() the same: " + ( str1 == str4.intern() ) ); //this should be "true" now
    System.out.println( "Are str1 and str5 the same: " + ( str1 == str5 ) );

  }
}
