package com.epam.allandnow.toconsole;

import java.util.Scanner;

public class RunScanner {
  public static void main( String[] args ) {
    System.out.println( "������� ���� ��� � ������� <Enter>:" );
    Scanner scan = new Scanner( System.in );
    String name = scan.next();
    System.out.println( "������, " + name );
    scan.close();
  }
}
