package com.epam.allandnow.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Yury_Bakhmutski on 8/10/2016.
 */
public class PesgreSQL {

  public static void main( String[] argv ) {

    System.out.println( "-------- Oracle JDBC Connection Testing ------" );

    try {

      Class.forName( "com.mysql.jdbc.Driver" );

    } catch ( ClassNotFoundException e ) {

      System.out.println( "Where is your Oracle JDBC Driver?" );
      e.printStackTrace();
      return;

    }

    System.out.println( "Oracle JDBC Driver Registered!" );

    Connection connection = null;

    try {

      connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/foodmart", "root", "root" );

    } catch ( SQLException e ) {

      System.out.println( "Connection Failed! Check output console" );
      e.printStackTrace();
      return;

    }

    if ( connection != null ) {
      System.out.println( "hibuser!" );
    } else {
      System.out.println( "Failed to make connection!" );
    }

    try {

      connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/foodmart", "quartz", "password" );

    } catch ( SQLException e ) {

      System.out.println( "Connection Failed! Check output console" );
      e.printStackTrace();
      return;

    }

    if ( connection != null ) {
      System.out.println( "quartz!" );
    } else {
      System.out.println( "Failed to make connection!" );
    }

    try {

      connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/foodmart", "pentaho_operations_mart",
          "pentaho_operations_mart" );

    } catch ( SQLException e ) {

      System.out.println( "Connection Failed! Check output console" );
      e.printStackTrace();
      return;

    }

    if ( connection != null ) {
      System.out.println( "pentaho_operations_mart!" );
    } else {
      System.out.println( "Failed to make connection!" );
    }
  }

}




