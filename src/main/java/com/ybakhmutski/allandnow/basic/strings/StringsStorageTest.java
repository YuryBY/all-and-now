package com.ybakhmutski.allandnow.basic.strings;

import java.io.IOException;

/**
 * Created by Yury_Bakhmutski on 6/11/2018.
 */
public class StringsStorageTest {
    public static void main(String[] args) {
        String s1 = "five";
        String s2 = new String("five");
        s2 = s2.intern();
        if (s1 == s2 )
            System.out.println(true);
        else
            System.out.println(false);

    /*    String s1 = "Java";
        String s2 = new String("Java");
        System.out.println(s1==s2);
        s2=s2.intern();
        System.out.println(s1==s2);*/
      /*  String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = new String(s1);
        System.out.println(s1==s2);
        System.out.println(s3==s4);
        System.out.println(s1==s3);*/
        /*    String s1 = "five".intern();
        String s2 = "five".intern();
        System.out.println("s1.equals(s2): "+s1.equals(s2));
        System.out.println("s1==s2: "+s1==s2);
        //s2.intern();
        //s1.intern();
        System.out.println("s1==s2: "+s1==s2);
        //If (s1 == s2 )
        //print(true)
        //Else
        //print (false)*/
        //method2();

    }

    final void method(int a){

    }

    static String method2() throws IOException{
        return "";
    }

}
 /*   public class StringsStorageTest{
        public static void doStatic(){
            System.out.println("");
        }
    }

     class B{
        public static void main(String args[]){
            StringsStorageTest a  =null;
            a.doStatic();
        }
    }*/


