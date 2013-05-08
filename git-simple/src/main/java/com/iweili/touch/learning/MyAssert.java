package com.iweili.touch.learning;

/**
 * Created with IntelliJ IDEA.
 * User: zhouwe
 * Date: 5/8/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 * Learning Java Assert
 */
public class MyAssert {

    public void run(String[] args) {

        for (final String arg : args){
            System.out.println(arg);
        }

        try {
            assertMe(false);
            assertMe(true);
        } catch (AssertionError e) {
            System.out.println("assert error catched: " + e);
        }
    }

    private void assertMe(boolean value){
        assert value : "value is false";
        System.out.println("assert true");
    }
}
