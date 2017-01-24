package com.epam.allandnow.objectmethods.clone;

public class CloneTest {

  public static void main( String[] args ) {
    checkIfConstructorIsCalled();
  }

  /**
   * Conclusion: constructor is not called when cloning.
   */
  private static void checkIfConstructorIsCalled() {
    ExperimentalClass a = new ExperimentalClass();
    System.out.println( "a: " + a );
    ExperimentalClass b = null;
    try {
      b = (ExperimentalClass) a.clone();
    } catch ( CloneNotSupportedException e ) {
      e.printStackTrace();
    }
    System.out.println( "b: " + b );
  }

}
