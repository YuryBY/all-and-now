package com.epam.allandnow.strings;

public class TestStringPDI12555 {

  public static void main( String[] args ) {
    TestStringPDI12555 thisOb = new TestStringPDI12555();

    String string = "d \"Joe Bloggs\" GmbH";
    System.out.println(string);
    string = thisOb.replace( string, new String[] { "\"" }, new String[] { "\\\"" } );
    
    System.out.println(string);
  }

  private String replace( String string, String[] searchStrings, String[] replaceStrings ) {
    StringBuilder builder = new StringBuilder( string );
    for ( int e = 0; e < Math.min( searchStrings.length, replaceStrings.length ); e++ ) {
      String chr = searchStrings[e];
      String rep = replaceStrings[e];
      int idx = builder.indexOf( chr, 0 );
      while ( idx > 0 ) {
        builder.replace( idx, idx + chr.length(), rep );
        idx = builder.indexOf( chr, idx + rep.length() );
      }
    }
    return builder.toString();
  }
}
