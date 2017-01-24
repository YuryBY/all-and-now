package com.epam.allandnow.multithreading;

/**
 * Created by Yury_Bakhmutski on 3/17/2016.
 */
public class ThreadStopWays {
  public static void main( String[] args ) {
    new ThreadStopWays().tryDestroy();
  }

  private void tryDestroy() {
    LocalThread[] localThreads = new LocalThread[10];
    for ( int i = 0; i < localThreads.length; i++ ) {
      localThreads[i] = new LocalThread( "!" + i + "!" );
      localThreads[i].start();
    }
    for ( int i = 0; i < localThreads.length; i++ ) {
      localThreads[i].stop();
    }
  }

  class LocalThread extends Thread {
    String name;

    LocalThread( String name ) {
      this.name = name;
    }
    @Override
    public void run() {
      try {
        int i = 0;
        System.out.println( "Thread " + name + " is started" );
        while ( true ) {
          try {
            System.out.println( "Thread " + name + " works and prints " + ++i );
            sleep( 300 );
          } catch ( InterruptedException e ) {
            e.printStackTrace();
          }
        }

      } catch ( Error e ){
        //e.printStackTrace();
      }
    }
  }

}
