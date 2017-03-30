package com.epam.allandnow.db;

import java.sql.*;

/**
 * Created by Yury_Bakhmutski on 6/27/2016.
 */
public class OracleJDBC {

  public static void main(String[] argv) {

    System.out.println("-------- Oracle JDBC Connection Testing ------");

    try {
      dmzOracle11();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  /**
   * the method is deprecated since IP was changed and db was removed.
   */
  @Deprecated
  private static void test_10_6_117_14() {
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
          "jdbc:oracle:thin:@10.6.117.14:1521/XE", "quartz", "password");
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
          "jdbc:oracle:thin:@10.6.117.14:1521/XE", "pentaho_operations_mart", "pentaho_operations_mart");
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

  private static void dmzOracle11() throws SQLException {
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
              "jdbc:oracle:thin:@10.177.176.208:1521/XE", "foodmart", "foodmart");
    } catch (SQLException e) {
      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
      return;
    }

    DatabaseMetaData metaData = connection.getMetaData();

    /*ResultSet tables = metaData.getTables("foodmart", null, "%", null);
    while (tables.next()){
      System.out.println(tables.getString(3));}*/

    String sql = "select a.* from ((OWNER, TABLE_NAME, TABLESPACE_NAME, CLUSTER_NAME, IOT_NAME, STATUS, PCT_FREE, PCT_USED, INI_TRANS, MAX_TRANS, INITIAL_EXTENT from ALL_ALL_TABLES) as a)";
    sql = "select * from TRANSPORTABLE_EXPORT_OBJECTS";
    sql = "SELECT DISTINCT \n" +
            "          \"TABLE_1\".\"OWNER\" AS \"COL0\"\n" +
            "         ,\"TABLE_1\".\"TABLE_NAME\" AS \"COL1\"\n" +
            "FROM " +
            "(\n" +
            "\t\t  SELECT\n" +
            "     \t\t  a.OWNER,a.TABLE_NAME,b.OBJECT_PATH,b.COMMENTS,a.TABLESPACE_NAME,a.CLUSTER_NAME FROM ALL_ALL_TABLES a, \n" +
            "\t     \t  TRANSPORTABLE_EXPORT_OBJECTS b) \"TABLE_1\"";
    //sql = "select OWNER, TABLE_NAME, TABLESPACE_NAME, CLUSTER_NAME, IOT_NAME, STATUS, PCT_FREE, PCT_USED, INI_TRANS, MAX_TRANS, INITIAL_EXTENT from ALL_ALL_TABLES";
    //sql = "select OWNER from \"OWNER, TABLE_NAME, TABLESPACE_NAME, CLUSTER_NAME, IOT_NAME, STATUS, PCT_FREE, PCT_USED, INI_TRANS, MAX_TRANS, INITIAL_EXTENT from ALL_ALL_TABLES\"";
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
      //Retrieve by column name
      ResultSetMetaData metaData1 = rs.getMetaData();
      for (int i = 1; i <= metaData1.getColumnCount(); i++) {
        System.out.println(metaData1.getColumnName(i));
      }
    }
    rs.close();
  }

}

