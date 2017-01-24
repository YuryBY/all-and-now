package com.epam.allandnow.reflection;

import java.lang.reflect.Method;

public class ABThruReflection {

  static A a = new A();
  static B b = new B();

  public static void main( String[] args ) {
    checkFmethod( a );
    checkFmethod( b );
  }

  private static void checkFmethod( Object arg ) {
    Class<?> clazz = arg.getClass();
    try {
      Method method = clazz.getMethod( "f", new Class[0] );
      method.invoke( arg );
    } catch ( Exception e ) {
      throw new RuntimeException( e );
    }

  }
}
