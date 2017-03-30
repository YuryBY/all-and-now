package com.epam.allandnow.multithreading;

/**
 * Created by Yury_Bakhmutski on 3/2/2016.
 */

/**
 * output variant:
 *
 * threads[Thread[Thread-3,5,main]]: 28
 * threads[Thread[Thread-2,5,main]]: 41
 * threads[Thread[Thread-1,5,main]]: 62
 * threads[Thread[Thread-0,5,main]]: 63
 * threads[1]: 64
 * threads[2]: 64
 * threads[3]: 64
 * threads[4]: 64
 * t1 - t0: 64
 * 1
 * 2
 * 3
 * 4
 */
public class MultithreadingCalculator {
  static final int COUNT = 4;

  public static void main( String[] args ) throws InterruptedException {
    int[] array = new int[100000000];
    array[1000] = 1;
    array[40000000] = 2;
    array[60000000] = 3;
    array[90000000] = 4;
    MaxValueCalculator[] maxValueCalculators = new MaxValueCalculator[COUNT];
    Thread[] threads = new Thread[COUNT];
    long t0 = System.currentTimeMillis();
    for ( int i = 0; i < COUNT; i++ ) {
      int lenth = array.length / COUNT;
      maxValueCalculators[i] = new MaxValueCalculator( array, lenth * i, lenth * ( i + 1 ) );
      threads[i] = new Thread( maxValueCalculators[i] );
      threads[i].start();
    }
    for ( int i = 0; i < COUNT; i++ ) {
      //when thread[i] returns from the .run
      threads[i].join();
      System.out.println( "threads[" + ( i + 1 ) + "]: " + ( System.currentTimeMillis() - t0 ) );
    }
    long t1 = System.currentTimeMillis();
    System.out.println( "t1 - t0: " + ( t1 - t0 ) );
    for ( int i = 0; i < COUNT; i++ ) {
      System.out.println( maxValueCalculators[i].maxValue );
    }
  }
}

class MaxValueCalculator implements Runnable {
  private final int[] array;
  private final int from;
  private final int to;
  public volatile int maxValue;

  MaxValueCalculator( int[] array, int from, int to ) {
    this.array = array;
    this.from = from;
    this.to = to;
  }

  @Override
  public void run() {
    long t0 = System.currentTimeMillis();
    int currentValue = array[from];

    for ( int i = from + 1; i < to; i++ ) {
      currentValue = Math.max( currentValue, array[i] );
    }
    maxValue = currentValue;
    System.out.println( "threads[" + Thread.currentThread() + "]: " + ( System.currentTimeMillis() - t0 ) );
  }
}

