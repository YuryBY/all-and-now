package com.epam.allandnow.multithreading;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Yury_Bakhmutski on 3/2/2016.
 */
public class MultithreadingFiaturesTester {
  public static void main( String[] args ) {
    //checkScheduler();
    new MultithreadingFiaturesTester().printCoresQuantity();
  }

  private static void checkScheduler() {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter("d:/the-file-name.txt", "UTF-8");
    } catch ( FileNotFoundException e ) {
      e.printStackTrace();
    } catch ( UnsupportedEncodingException e ) {
      e.printStackTrace();
    }
    writer.println("The first line");
    writer.println("The second line");
    writer.close();
  }

  private void printCoresQuantity() {
    new Thread( new MyRunnable() ).start();
    //System.out.println(Runtime.getRuntime().availableProcessors() );
  }

  class MyRunnable implements Runnable{
    @Override
    public void run() {
      while ( true ){
        System.out.println("qwert");
      }
    }
  }

}
