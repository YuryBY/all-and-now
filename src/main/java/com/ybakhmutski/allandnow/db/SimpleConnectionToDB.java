package com.epam.allandnow.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleConnectionToDB {

  public static void main( String[] args ) {
    //ConnectToMysql();
    ConnectToIngres();
    //testNPStringLength();
 }

  private static void testNPStringLength() {
    String testString = null;
    System.out.println( testString.length() );
  }

  private static void ConnectToMysql() {
    final String dbUrl = "jdbc:mysql://localhost/foodmart_mysql";
    // Database credentials
    final String user = "root";
    final String pass = "root";
    Connection conn = null;
    Statement stmt = null;
    try {
      // STEP 2: Register JDBC driver
      Class.forName( "com.mysql.jdbc.Driver" );
      // STEP 3: Open a connection
      System.out.println( "Connecting to database..." );
      conn = DriverManager.getConnection( dbUrl, user, pass );

      List<String> tablesNamesList = new ArrayList<String>();
      getTablesNamesAsList( conn, tablesNamesList );

      // System.out.println(Arrays.toString(tablesNamesList.toArray()));
      getAndPrintColumnsNames( conn, tablesNamesList.get( 0 ) );

      /*   //STEP 4: Execute a query
         System.out.println("Creating statement...");
         stmt = conn.createStatement();
         String sql;
         sql = "SELECT id, first, last, age FROM Employees";
         ResultSet rs = stmt.executeQuery(sql);

         //STEP 5: Extract data from result set
         while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first");
            String last = rs.getString("last");

            //Display values
            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", First: " + first);
            System.out.println(", Last: " + last);
         }*/
         //STEP 6: Clean-up environment
       //  rs.close();
         //stmt.close();
      conn.close();
    } catch ( SQLException se ) {
      // Handle errors for JDBC
      se.printStackTrace();
    } catch ( Exception e ) {
      // Handle errors for Class.forName
      e.printStackTrace();
    } finally {
      // finally block used to close resources
      try {
        if ( stmt != null )
          stmt.close();
      } catch ( SQLException se2 ) {
      }// nothing we can do
      try {
        if ( conn != null )
          conn.close();
      } catch ( SQLException se ) {
        se.printStackTrace();
      }
    }

  }

  private static void getTablesNamesAsList( Connection conn, List<String> tablesNamesList ) throws Exception {
    DatabaseMetaData md = conn.getMetaData();
    ResultSet rs = md.getTables( null, null, "%", null );
    while ( rs.next() ) {
      String currentName = rs.getString( 3 );
      tablesNamesList.add( currentName );
      // System.out.println( currentName );
    }
  }

  private static void ConnectToIngres() {
    final String foodmartDBName = "foodmart";
    final String dbUrl = "jdbc:ingres://10.177.176.133:VW7/" + foodmartDBName;
    final String user = "ingres";
    final String pass = "ingres ";
    
    String dropTable =
        "DROP TABLE PDI_12555_e";
    
    String createTableSQL =
        "CREATE TABLE PDI_12555 " + "(id INTEGER not NULL, " + " value VARCHAR(255), " + " PRIMARY KEY ( id ))";

    String insertSQL = "INSERT INTO PDI_12555 " + "VALUES (1, 'Masha')";

    String selectSQL = "Select * from pdi_12555_e";
    
    String dropSQL = "delete from pdi_12555_e";
    
    Connection conn = null;
    Statement stmt = null;
    try {
      // STEP 2: Register JDBC driver
      Class.forName( "com.ingres.jdbc.IngresDriver" );

      System.out.println( "Connecting to database..." );
      conn = DriverManager.getConnection( dbUrl, user, pass );

      List<String> tablesNamesList = new ArrayList<String>();
      getTablesNamesAsList( conn, tablesNamesList );

      System.out.println( Arrays.toString( tablesNamesList.toArray() ) );
      getAndPrintColumnsNames( conn, "pdi_12555" );

      //runExecuteSQL(conn,stmt, selectSQL);
      runUpdateSQL( conn, stmt, dropSQL );

      conn.close();
    } catch ( SQLException se ) {
      // Handle errors for JDBC
      se.printStackTrace();
    } catch ( Exception e ) {
      // Handle errors for Class.forName
      e.printStackTrace();
    } finally {
      // finally block used to close resources
      try {
        if ( stmt != null )
          stmt.close();
      } catch ( SQLException se2 ) {
      }// nothing we can do
      try {
        if ( conn != null )
          conn.close();
      } catch ( SQLException se ) {
        se.printStackTrace();
      }
    }
  }

  private static void runUpdateSQL( Connection conn, Statement stmt, String sQLForExecuting ) throws Exception {
    stmt = conn.createStatement();
    // STEP 4: Execute a query
    System.out.println( "Executing update..." );
    stmt.executeUpdate(sQLForExecuting);
    stmt.close();
  }

  private static void runExecuteSQL( Connection conn, Statement stmt, String sQLForExecuting ) throws Exception {
    // STEP 4: Execute a query
    System.out.println( "Creating statement..." );
    stmt = conn.createStatement();
    String sql = sQLForExecuting;
    ResultSet rs = stmt.executeQuery( sql );

    // STEP 5: Extract data from result set
    while ( rs.next() ) {
      // Retrieve by column name
      int id = rs.getInt( "id" );
      //int age = rs.getInt( "age" );
      String first = rs.getString( "value" );
      //String last = rs.getString( "last" );
      // Display values
      System.out.print( "\nFirst Name: " + first + " | " );
      System.out.print( "ID: " + id + " | " );
      //System.out.print( "Age: " + age + " | " );
      //System.out.print( "Last Name: " + last + " | " );
    }
    // STEP 6: Clean-up environment
    rs.close();
    stmt.close();
  }

  private static void getAndPrintColumnsNames( Connection conn, String tableName ) throws Exception {
    ResultSet rsColumns = null;
    DatabaseMetaData meta = conn.getMetaData();
    rsColumns = meta.getColumns( null, null, tableName, null );
    while ( rsColumns.next() ) {
      String columnName = rsColumns.getString( "COLUMN_NAME" );
      System.out.println( "column name=" + columnName );
      String columnType = rsColumns.getString( "TYPE_NAME" );
      System.out.println( "type:" + columnType );
     // int size = rsColumns.getInt( "COLUMN_SIZE" );
      //System.out.println( "size:" + size );
      //int nullable = rsColumns.getInt( "NULLABLE" );
      //if ( nullable == DatabaseMetaData.columnNullable ) {
       // System.out.println( "nullable true" );
      //} else {
       // System.out.println( "nullable false" );
      //}
      //int position = rsColumns.getInt( "ORDINAL_POSITION" );
      //System.out.println( "position:" + position );
    }
  }

}
