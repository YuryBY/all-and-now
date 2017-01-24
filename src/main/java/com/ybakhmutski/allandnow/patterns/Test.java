package com.epam.allandnow.patterns;

public class Test {
  public static void main( String[] args ) {
    AdreessBuilder adreessBuilder = new AdreessBuilder().city( "NY" ).country( "USA" );
    Address address = adreessBuilder.state( "NY" ).build();
    System.out.println( address );
  }
}
