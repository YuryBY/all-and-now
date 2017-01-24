package com.epam.allandnow.strings;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.java.swing.plaf.windows.WindowsTreeUI.CollapsedIcon;

public class ArraysString {

 public static void main( String[] args ) {
  method();
 }

private static void method() {
  
  String[] args = {"import", "--target-dir", "/home/mapr/out/"};
  
  
  ArrayList ar = new ArrayList(Arrays.asList( args ));
  ar.add( "--jar-file mydatatypes.jar" );
  args = (String[]) ar.toArray();
}  
  
}
