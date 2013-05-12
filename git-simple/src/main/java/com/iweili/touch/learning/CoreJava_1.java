package com.iweili.touch.learning;

/**
 * Created with IntelliJ IDEA.
 * User: wei
 * Date: 5/11/13
 * Time: 2:21 PM
 *
 * Core Java Section 1
 */
public class CoreJava_1 {
    public void run(){
        String greeting = "Hello";
        int n = greeting.length();

        int cpCount = greeting.codePointCount(0, greeting.length());

        char first = greeting.charAt(0);
        char last = greeting.charAt(4);

        int index = greeting.offsetByCodePoints(0, 2);
        int cp = greeting.codePointAt(index);

        System.out.println(cpCount);
        System.out.println(index);
        System.out.println(cp);

    }
}
