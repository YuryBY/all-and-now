package com.epam.allandnow.basic;

/**
 * Created by Yury_Bakhmutski on 3/2/2016.
 */
public class StrictfpTester {

  public static void main( String[] args ) {
    System.out.println(Runtime.getRuntime().availableProcessors() );
    System.out.println( "new NoStrictFPClass().calculate(): " + new NoStrictFPClass().calculate() );
    System.out.println("new StrictFPClass().calculate(): "+new StrictFPClass().calculate());
  }


}

class NoStrictFPClass {
  double num1 = 10e+102;
  double num2 = 6e+08;
  double calculate() {
    return num1 + num2;
  }
}

strictfp class StrictFPClass {
  double num1 = 10e+102;
  double num2 = 6e+08;
  double calculate() {
    return num1 + num2;
  }
}
