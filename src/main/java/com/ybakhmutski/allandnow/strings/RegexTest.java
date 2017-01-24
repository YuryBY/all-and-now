package com.epam.allandnow.strings;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

  public static void main( String[] args ) {
    detectSlashes();
  }

  private static void detectSlashes() {
    String draftPath = "localhost:8080///pentaho/Login";

    String result = draftPath.replaceAll("(/)+", "/");
    System.out.println(result);

    //draftPath = "localhost:8080\\\\\\pentaho\\Login";
    //result = draftPath.replaceAll("(\\\\)+", "\\");
    draftPath = "localhost:8080/////////////pentaho//Login";
    result = draftPath.replaceAll("(/)+", "/");
    System.out.println(result);

    //String regex = ".*\\/plugin\\/([^/]+)\\/api\\/application.wadl";
    //regex = ".*\\/{1+}([^/]+)\\/api\\/application.wadl";

    //Pattern pluginPattern = Pattern.compile(regex);
    //Matcher pluginMatcher = pluginPattern.matcher( draftPath );

    //String plugin = null;
    //if ( pluginMatcher.matches() ) {
//      System.out.println("found!");
  //    plugin = pluginMatcher.group( 1 );
    //}

  }

  private static void runAndLog0() {
    testMondrianLevel();

    System.out.println(System.getProperty("line.separator"));
    // testSubstitutions();

    // String in = "\"in quotes\" after quotes";
    // testPerformance( in );

    String cmd="";

/*  System.out.println( "Executing command: " + cmd.substring( 0, cmd.indexOf( "[" ) ) + "[username,password]"
        + cmd.substring( cmd.indexOf( "]" ) + 1 ) );
*/
    //whatFaster();
  }

  private static void testMondrianLevel() {
   String levelName = "[Markets].[AP AC]";  
	System.out.println(levelName.matches("\\[[\\w ]+\\]$"));
		
	Pattern pattern = Pattern.compile("\\[[\\w ]+\\]$");
	Matcher matcher = pattern.matcher(levelName);
	if (matcher.find())
	{
	    System.out.println(matcher.group(0));
	}
}

private static void whatFaster() {
    String in =
        "\"in quotes\" after quotes sdfas df f sadfl;kasjdf alskdf lkasdf lasd fla sjdflk asldkfa fasdlflklkjas"
            + "sdfsfsdfsd" + "fgsfdggggggggggggggggggggggggg" + "sdgfhssssssssstrhwsrthrtdlkfjlkasdjflk asdf";

    try {
      in = readFile( "d:\\Spoon.txt", Charset.defaultCharset() );
    } catch ( IOException e ) {
      e.printStackTrace();
    }
   // System.out.println( in );

    usingPentahoAlgoritmTimeShower( in, new String[] { "\"", "a", "s", "q", "sd","f" }, new String[] { "\\\"", "e", "d", "*", "ds","fasdfasd" } );
    usingPentahoAlgoritmUpdatedTimeShower( in, new String[] { "\"", "a", "s", "q", "sd","f" }, new String[] { "\\\"", "e", "d", "*", "ds","fasdfasd" });

  }

  static String readFile( String path, Charset encoding ) throws IOException {
    byte[] encoded = Files.readAllBytes( Paths.get( path ) );
    return new String( encoded, encoding );
  }

  private static void usingPentahoAlgoritmUpdatedTimeShower( String in, String[] strings, String[] strings2 ) {
    long start = System.currentTimeMillis();
    String result = "";
    result = usingPentahoAlgoritmUpdated( in, strings, strings2 );
    System.out.println( "result: " + ", time(usingPentahoAlgoritmUpdated): "
        + ( System.currentTimeMillis() - start ) );
  }

  private static void usingPentahoAlgoritmTimeShower( String in, String[] strings, String[] strings2 ) {
    long start = System.currentTimeMillis();
    String result = "";
    result = usingPentahoAlgoritm( in, strings, strings2 );
    System.out
        .println( "result: "  + ", time(usingPentahoAlgoritm): " + ( System.currentTimeMillis() - start ) );
  }

  private static void testPerformance( String in ) {
    String regex = "\"";
    String substitution = "\\\"";
    testMatchersInString( in, regex, substitution );
    testReplaceAllString( in, regex, substitution );
    testReplaceString( in, regex, substitution );
    testPentahoAlgoritm( in, regex, substitution );
  }

  private static void testPentahoAlgoritm( String in, String regex, String substitution ) {
    long start = System.currentTimeMillis();
    String result = "";
    result = usingPentahoAlgoritm( in, new String[] { "\"" }, new String[] { "\\\"" } );
    System.out
        .println( "result: " + result + ", time(usingPentahoAlgoritm): " + ( System.currentTimeMillis() - start ) );

  }

  private static String usingPentahoAlgoritm( String string, String[] searchStrings, String[] replaceStrings ) {
    StringBuilder builder = new StringBuilder( string );
    for ( int e = 0; e < Math.min( searchStrings.length, replaceStrings.length ); e++ ) {
      String chr = searchStrings[e];
      String rep = replaceStrings[e];
      int idx = builder.indexOf( chr, 0 );
      while ( idx >= 0 ) {
        builder.replace( idx, idx + chr.length(), rep );
        idx = builder.indexOf( chr, idx + rep.length() );
      }
    }
    return builder.toString();
  }

  private static String usingPentahoAlgoritmUpdated( String string, String[] searchStrings, String[] replaceStrings ) {
    StringBuilder builder = new StringBuilder( string );
    for ( int e = 0; e < Math.min( searchStrings.length, replaceStrings.length ); e++ ) {
      String chr = searchStrings[e];
      String rep = replaceStrings[e];
      int idx = builder.indexOf( chr, 0 );
      while ( idx != -1 ) {
        builder.replace( idx, idx + chr.length(), rep );
        idx = builder.indexOf( chr, idx + rep.length() );
      }
    }
    return builder.toString();
  }

  private static void testReplaceString( String in, String regex, String substitution ) {
    long start = System.currentTimeMillis();
    String result = "";
    result = usingStringReplaceMethod( in, regex, substitution );
    System.out.println( "result: " + result + ", time(using replace): " + ( System.currentTimeMillis() - start ) );
  }

  private static String usingStringReplaceMethod( String in, String oldCh, String newCh ) {
    long start = System.currentTimeMillis();
    String result = "";
    result = in.replace( oldCh, newCh );
    return result;
  }

  private static void testReplaceAllString( String in, String regex, String substitution ) {
    long start = System.currentTimeMillis();
    String result = "";
    result = usingStringReplaceAllMethod( in, regex, substitution );
    System.out.println( "result: " + result + ", time(using replaceAll): " + ( System.currentTimeMillis() - start ) );
  }

  private static void testMatchersInString( String in, String regex, String substitution ) {
    long start = System.currentTimeMillis();
    String result = "";
    result = usingMatchers( in, regex, substitution );
    System.out.println( "result: " + result + ", time(using matchers in string): "
        + ( System.currentTimeMillis() - start ) );
  }

  private static void testSubstitutions() {
    String input =
        "/opt/Actian/IngresII/ingres/bin/sql -u ingres -P ingres -f | -t pdi_12555 -C UTF-8 -l ' foodmart /opt/Actian/IngresII/ingres/fifoVW_test";

    String regex = "-u\\s.*\\s-P\\s.*?\\s";
    String substitution = "-u LOGIN, -P PASSWORD ";

    String result = "";

    // System.out.println( input.matches( ".*-u\\\\s.*\\\\s-P\\\\s.*?\\\\s.*" ) );

    result = usingStringReplaceAllMethod( input, regex, substitution );
    System.out.println( "1: " + result );

    result = usingMatchers( input, regex, substitution );
    System.out.println( "2: " + result );

    input = "/opt/Actian/IngresII/ingres/bin/sql @10.177.176.133,VW[ingres,ingres]::foodmart";
    regex = "\\[.*,.*\\]";
    substitution = "[ingres, ingres]";

    result = usingMatchers( input, regex, substitution );
    System.out.println( "3: " + result );
  }

  private static String usingMatchers( String input, String regex, String substitution ) {
    Pattern replace = Pattern.compile( regex );
    Matcher matcher2 = replace.matcher( input );
    if ( matcher2.find() ) {
      return matcher2.replaceAll( substitution );
    }
    return "!!!!!!!";
  }

  private static String usingStringReplaceAllMethod( String input, String regex, String substitution ) {
    return input.replaceAll( regex, substitution );
  }
}
