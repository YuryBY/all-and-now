package com.epam.allandnow.multithreading;

/**
 * Created by Yury_Bakhmutski on 3/2/2016.
 */
public class PrinterToConsole {

  public static void main( String[] args ) throws InterruptedException {
    Thread thread = new Thread( new MyRunnable() );
    thread.start();
    while ( true ){
      Thread.sleep( 100 );
      System.out.println("Hello");
      PrinterToConsole.class.notify();
    }
  } 
  
}

class MyRunnable implements Runnable{
  @Override
  public void run() {
    int k = 0;
    while ( true ){
      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
      System.out.println(k++);
      try {
        PrinterToConsole.class.wait();
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }
  }
}
