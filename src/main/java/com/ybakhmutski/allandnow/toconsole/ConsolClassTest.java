package com.epam.allandnow.toconsole;

import java.io.Console;

public class ConsolClassTest {
  public static void main( String[] args ) {
    Integer first = 0;
    Integer second = 0;
    Console c = System.console();
    String currentInput = "";
    System.out.print( "First: " );
    currentInput = c.readLine();
    first = toInteger( currentInput );
    System.out.print( "Second: " );
    currentInput = c.readLine();
    second = toInteger( currentInput );
    System.out.println( "Summ: " + ( first + second ) );
    c.format( "\nPress ENTER to proceed.\n" );
    c.readLine();
  }

  private static Integer toInteger( String currentInput ) {
    int result = 0;
    try {
      result = Integer.parseInt( currentInput );
    } catch ( NumberFormatException e ) {
      System.err.println( "Not a string!" );
    }
    return result;
  }
}
