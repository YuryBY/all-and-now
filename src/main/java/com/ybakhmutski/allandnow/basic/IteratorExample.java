package com.ybakhmutski.allandnow.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Yury_Bakhmutski on 12/27/2017.
 */
public class IteratorExample {


    public static void main(String args[]) {
        List<String> myList = new ArrayList<String>();

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        Iterator<String> it = myList.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println("List Value:" + value);
            if (value.equals("3")) myList.remove(value);
        }

        /*Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");

        Iterator<String> it1 = myMap.keySet().iterator();
        while (it1.hasNext()) {
            String key = it1.next();
            System.out.println("Map Value:" + myMap.get(key));
            if (key.equals("2")) {
                myMap.put("1", "4");
                //myMap.put("4", "4");
            }
        }*/

    }

}