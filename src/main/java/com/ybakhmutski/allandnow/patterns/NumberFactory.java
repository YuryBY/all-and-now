package com.epam.allandnow.patterns;

import com.epam.allandnow.patterns.util.DefaultNumerRepresentator;

import java.util.Properties;

/**
 * Created by Yury_Bakhmutski on 4/13/2016.
 */
public class NumberFactory {

  /**
   * Get default formatter for number values.
   * Should always return an only instance of {@link DefaultNumberFormatter}.
   *
   * @return singleton default formatter
   */

  private static DefaultNumerRepresentator formatter = new DefaultNumerRepresentator();

  public static DefaultNumerRepresentator getDefaultNumberFormatter() {
    return formatter;//new DefaultNumerRepresentator();//DefaultNumerRepresentatorHolder.formatter;
  }

  private static class DefaultNumerRepresentatorHolder {
    static DefaultNumerRepresentator formatter = new DefaultNumerRepresentator();
  }

  public static void main( String[] args ) {
    Properties properties = System.getProperties();
    System.out.println(properties);
  }




}

