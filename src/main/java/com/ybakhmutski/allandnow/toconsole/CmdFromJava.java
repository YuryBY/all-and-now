package com.epam.allandnow.toconsole;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class CmdFromJava {

  public static void main( String[] args ) {
    method();
  }

  private static void method() {
    PrintStream prtStrm = System.out;
    try {
      Process pr = Runtime.getRuntime().exec( "cmd echo yo!" );
      OutputStream outS = pr.getOutputStream();
      prtStrm = new PrintStream( outS );
      prtStrm.println();
    } catch ( IOException e ) {
      e.printStackTrace();
    }

  }

}
