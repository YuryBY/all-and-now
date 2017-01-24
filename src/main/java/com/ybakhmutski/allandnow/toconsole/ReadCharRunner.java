package com.epam.allandnow.toconsole;

public class ReadCharRunner {
  public static void main( String[] args ) {
    int x;
    try {
      System.out.print( "Enter symbol: " );
      x = System.in.read();
      char c = (char) x;
      System.out.println( "Char: " + c + " =" + x );
    } catch ( java.io.IOException e ) {
      System.err.println( "eror" + e );
    }
  }
}
