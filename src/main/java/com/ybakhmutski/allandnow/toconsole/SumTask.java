package com.epam.allandnow.toconsole;

public class SumTask {
  public static void main( String[] args ) {
    int first;
    int second;
    try {
      System.out.print( "First: " );
      first = (int) System.in.read();
      System.out.println( "Second: " );
      second = (int) System.in.read();
      System.out.println( "Summ: " + ( first + second ) );
    } catch ( java.io.IOException e ) {
      System.err.println( "eror" + e );
    }
  }
}
