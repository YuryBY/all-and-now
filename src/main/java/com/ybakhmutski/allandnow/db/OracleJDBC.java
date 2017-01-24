package com.epam.allandnow.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Yury_Bakhmutski on 6/27/2016.
 */
public class OracleJDBC {

  public static void main(String[] argv) {

    System.out.println("-------- Oracle JDBC Connection Testing ------");

    try {

      Class.forName("oracle.jdbc.driver.OracleDriver");

    } catch (ClassNotFoundException e) {

      System.out.println("Where is your Oracle JDBC Driver?");
      e.printStackTrace();
      return;

    }

    System.out.println("Oracle JDBC Driver Registered!");

    Connection connection = null;

    try {

      connection = DriverManager.getConnection(
          "jdbc:oracle:thin:@10.6.117.14:1521/XE", "hibuser",
          "password");

    } catch (SQLException e) {

      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
      return;

    }

    if (connection != null) {
      System.out.println("hibuser!");
    } else {
      System.out.println("Failed to make connection!");
    }

    try {

      connection = DriverManager.getConnection(
          "jdbc:oracle:thin:@10.6.117.14:1521/XE", "quartz",
          "password");

    } catch (SQLException e) {

      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
      return;

    }

    if (connection != null) {
      System.out.println("quartz!");
    } else {
      System.out.println("Failed to make connection!");
    }

    try {

      connection = DriverManager.getConnection(
          "jdbc:oracle:thin:@10.6.117.14:1521/XE", "pentaho_operations_mart",
          "pentaho_operations_mart");

    } catch (SQLException e) {

      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
      return;

    }

    if (connection != null) {
      System.out.println("pentaho_operations_mart!");
    } else {
      System.out.println("Failed to make connection!");
    }
  }

}

