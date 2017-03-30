package com.epam.allandnow.websirvice;

import javax.xml.ws.Endpoint;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Endpoint publisher
public class HelloWorldPublisher{

  static Map<Object, Integer> map = new HashMap<Object, Integer>();


  public static void main(String[] args) {
    //Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
    Object ob1 = new Object();
    int i = 1;
    System.out.println(map);
    map.put( ob1,i );
    System.out.println("----------");
    System.out.println(map);
    System.out.println(map.containsValue(1));
    String[] sheetNames = new String[0];
    System.out.println(sheetNames.length);
  }


}
