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
    if (!registerDriver()) return;

    String url = "jdbc:oracle:thin:@10.6.117.14:1521/XE";
    String user = "hibuser";
    String password = "password";
    demonstrateConnection(url, user, password);

    user = "quartz";
    demonstrateConnection(url, user, password);

    user = "pentaho_operations_mart";
    password = "pentaho_operations_mart";
    demonstrateConnection(url, user, password);
  }

  private static boolean registerDriver() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {

      System.out.println("Where is your Oracle JDBC Driver?");
      e.printStackTrace();
      return false;

    }
    System.out.println("Oracle JDBC Driver Registered!");
    return true;
  }


  private static void demonstrateConnection(String url, String user, String password) {
    Connection connection = createConnection(url, user, password);
    if (connection != null) {
      System.out.println(user + " is connected!");
    } else {
      System.out.println("Failed to make connection!");
    }
  }

  private static Connection createConnection(String url, String user, String password) {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
    }
    return connection;
  }

  private static void dmzOracle11() throws SQLException {
    if (!registerDriver()) return;

    String url = "jdbc:oracle:thin:@10.177.176.208:1521/XE";
    String user = "foodmart";
    String password = "foodmart";
    Connection connection = createConnection(url, password, user);

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
    //sql = "select * from employee";
    sql = "select * from EMPLOYEE";

    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    ResultSetMetaData metadata = rs.getMetaData();
    int columnCount = metadata.getColumnCount();
    for (int i = 1; i <= columnCount; i++) {
      System.out.println(metadata.getColumnName(i) + ", ");
    }
    System.out.println();
    while (rs.next()) {
      String row = "";
      for (int i = 1; i <= columnCount; i++) {
        row += rs.getString(i) + ", ";
      }
      System.out.println();

    }

    DatabaseMetaData md = connection.getMetaData();
    /*ResultSet rs = md.getTables(null, null, "%", null);
    while (rs.next()) {
      System.out.println(rs.getString(3));
    }*/

//    Statement stmt = connection.createStatement();
  //  ResultSet rs = stmt.executeQuery(sql);



    // get result set meta data
    ResultSetMetaData rsMetaData = rs.getMetaData();
    int numberOfColumns = rsMetaData.getColumnCount();

    // get the column names; column indexes start from 1
    for (int i = 1; i < numberOfColumns + 1; i++) {
      String columnName = rsMetaData.getColumnName(i);
      // Get the name of the column's table name
      String tableName = rsMetaData.getTableName(i);
      System.out.println("column name=" + columnName + " table=" + tableName + "");
    }

    while (rs.next()) {
      //Retrieve by column name
      ResultSetMetaData metaData1 = rs.getMetaData();
      for (int i = 1; i <= metaData1.getColumnCount(); i++) {
        //System.out.println(metaData1.getColumnName(i));
      }
    }
    rs.close();
  }

}

