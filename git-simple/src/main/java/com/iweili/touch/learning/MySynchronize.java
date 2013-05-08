package com.iweili.touch.learning;

/**
 * Created with IntelliJ IDEA.
 * User: zhouwe
 * Date: 5/8/13
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 * Learning java synchronize.
 */
public class MySynchronize implements Runnable {

    public static void mainRun(String [] args){
        MySynchronize mySynchronize = new MySynchronize();

        Thread thread1 = new Thread(mySynchronize, "A");
        Thread thread2 = new Thread(mySynchronize, "B");

        thread1.start();
        thread2.start();


    }

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i<5; i++){
                System.out.println(Thread.currentThread().getName()+" synchronized loop " + i);
            }
        }
    }
}
