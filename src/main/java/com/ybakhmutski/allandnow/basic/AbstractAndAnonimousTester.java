package com.epam.allandnow.basic;

public class AbstractAndAnonimousTester {

  public static void main( String[] args ) {
    new GO() {
    }.yo();

  }

  AbstractAndAnonimousTester( int d ) {
    System.out.println( "Yo!" );
  }
}

abstract class GO {
  public void yo() {

    new AbstractAndAnonimousTester( 12 ) {
      private void syso() {
        System.out.println( "Ho!" );

      }
    }.syso();
  }
}
