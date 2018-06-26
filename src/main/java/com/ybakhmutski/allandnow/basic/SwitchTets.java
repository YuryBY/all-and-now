package com.ybakhmutski.allandnow.basic;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Yury_Bakhmutski on 6/20/2017.
 */
public class SwitchTets {
    public static void main(String[] args) {
        theMethod();
    }

    private static void theMethod() {

int parametersQuantity = 12;

        switch( parametersQuantity ) {
            case 0:
            default:
                System.out.println("0");
                break;
            case 2:
                System.out.println("2");
                break;
            case 4:
                System.out.println("4");
                break;
        }

    }
}
