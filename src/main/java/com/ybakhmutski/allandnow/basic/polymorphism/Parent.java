package com.ybakhmutski.allandnow.basic.polymorphism;

/**
 * Created by Yury_Bakhmutski on 6/12/2018.
 */
public class Parent {

    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        // we pass the object to foo
        foo(aDog);
        // aDog variable is still pointing to the "Max" dog when foo(...) returns
        aDog.getName().equals("Max"); // true, java passes by value
        aDog.getName().equals("Fifi"); // false
    }

    public static void foo(Dog d) {
        d.getName().equals("Max"); // true
        // change d inside of foo() to point to a new Dog instance "Fifi"
        d = new Dog("Fifi");
        d.getName().equals("Fifi"); // true
    }



    private static class Dog {
        Dog(String name) {
            this.name = name;
        }

        String name;

        public String getName() {
            //System.out.println(name);
            return name;
        }
    }
}
