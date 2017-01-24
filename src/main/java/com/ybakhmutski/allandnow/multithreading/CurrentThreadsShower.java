package com.epam.allandnow.multithreading;

/**
 * Created by Yury_Bakhmutski on 3/15/2016.
 *
 * Execution example:
 * Thread[main,5,main]
 * Thread[Monitor Ctrl-Break,5,main]
 *
 */
public class CurrentThreadsShower {
  public static void main( String[] args ) {
    Thread[] array = new Thread[Thread.activeCount()];
    Thread.enumerate( array );
    for ( Thread t : array ) {
      System.out.println( t );
    }
    while ( true );
  }
}
