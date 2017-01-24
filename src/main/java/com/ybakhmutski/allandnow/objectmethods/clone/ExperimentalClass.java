package com.epam.allandnow.objectmethods.clone;

public class ExperimentalClass implements Cloneable {

  public ExperimentalClass() {
    System.out.println( "In constructor" );
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

}
