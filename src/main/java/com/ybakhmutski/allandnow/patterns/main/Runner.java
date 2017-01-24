package com.epam.allandnow.patterns.main;

import com.epam.allandnow.patterns.NumberFactory;
import com.epam.allandnow.patterns.util.DefaultNumerRepresentator;

/**
 * Created by Yury_Bakhmutski on 4/13/2016.
 */
public class Runner {
  public static void main( String[] args ) {
    DefaultNumerRepresentator defaultNumberFormatter1 = NumberFactory.getDefaultNumberFormatter();
    DefaultNumerRepresentator defaultNumberFormatter2 = NumberFactory.getDefaultNumberFormatter();

    System.out.println( defaultNumberFormatter1 == defaultNumberFormatter2 );
  }
}
