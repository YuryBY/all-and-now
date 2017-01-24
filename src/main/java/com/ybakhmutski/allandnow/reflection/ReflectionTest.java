package com.epam.allandnow.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.epam.allandnow.basic.OperandsPriorityTest;

public class ReflectionTest {

  public static void main( String[] args ) throws InstantiationException, IllegalAccessException,
    ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
    // dynamic way:
    Class clazz = Class.forName( "com.epam.allandnow.basic.OperandsPriorityTest" );
    OperandsPriorityTest ref = (OperandsPriorityTest) clazz.newInstance();
    /*ref.setStringField( "new" );
    System.out.println( ref );*/

    // static way
    Class<?> clazz1 = OperandsPriorityTest.class;
    OperandsPriorityTest ref1 = (OperandsPriorityTest) clazz1.newInstance();
    /*ref.setStringField( "new" );
    System.out.println( ref1 );*/

    // static or dynamic depend on way of ref1 getting 
    Class<?> clazz2 = ref1.getClass();
    OperandsPriorityTest ref2 = (OperandsPriorityTest) clazz2.newInstance();

    Method[] methods = clazz.getDeclaredMethods();
    methods[4].invoke( ref, "Yo!" );
    System.out.println(methods[5].invoke( ref ));
    for ( int i = 0; i < methods.length; i++ ) {
      System.out.println( "i:" + i + " " + methods[i].getName() );
    }
    
    
    /*ref.setStringField( "new" );
    System.out.println( ref2 );*/

  }

}
