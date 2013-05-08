package com.iweili.touch;

import com.iweili.touch.learning.JavaAssert;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        JavaAssert javaAssert = new JavaAssert();
        javaAssert.run(args);
    }

}
