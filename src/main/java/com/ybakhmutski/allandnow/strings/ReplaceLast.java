package com.epam.allandnow.strings;

/**
 * Created by Yury_Bakhmutski on 9/8/2016.
 */
public class ReplaceLast {

  public static void main( String[] args ) {

    //method_1();
    //method_2();
    String in = "[Date].[All Dates].[2016-01-06 00:00:00.0]";
    in = "[Date].[All Dates].[2016-01-06]";
    System.out.println(prepareDateFormula(in));
  }

  private static String prepareDateFormula( String memberFormula ) {
    String time = " 00:00:00.0";
    if ( memberFormula.contains( time ) ) {
      return memberFormula;
    }
    String bracket = "]";
    int pos = memberFormula.lastIndexOf( bracket );
    if ( pos > -1 ) {
      return memberFormula.substring( 0, pos ) + time + bracket;
    } else {
      return memberFormula;
    }
  }

  private static void method_2() {
    String in = "[Date].[All Dates].[2016-01-06 00:00:00.0]";
    in = "[Date].[All Dates].[2016-01-06]";
    String bracket = "]";
    String time = " 00:00:00.0";
    int pos = in.lastIndexOf(bracket);
    if (pos > -1) {
      String result = in.substring( 0, pos ) + time + bracket;
      System.out.println("result"+result);
      //+ string.substring(pos + toReplace.length(), string.length());
    } else {
      System.out.println("!");
    }
  }

  private static void method_1() {
    String in = "[Date].[All Dates].[2016-01-06 00:00:00.0]";
    in = "[Date].[All Dates].[2016-01-06]";
    String replace = "]";
    String replacement = " 00:00:00.0]";
    System.out.println(replaceLast( in,replace,replacement ));
  }

  public static String replaceLast(String string, String toReplace, String replacement) {
    int pos = string.lastIndexOf(toReplace);
    if (pos > -1) {
      return string.substring(0, pos)
          + replacement;
          //+ string.substring(pos + toReplace.length(), string.length());
    } else {
      return string;
    }
  }
}
