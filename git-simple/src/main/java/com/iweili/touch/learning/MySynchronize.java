package com.iweili.touch.learning;

/**
 * Created with IntelliJ IDEA.
 * User: zhouwe
 * Date: 5/8/13
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 *
 * Learning java synchronize.
 * http://www.cnblogs.com/GnagWang/archive/2011/02/27/1966606.html
 */
public class MySynchronize implements Runnable {

    public static void mainRun(String [] args){
//        //region section 1
//        MySynchronize mySynchronize = new MySynchronize();
//
//        Thread thread1 = new Thread(mySynchronize, "A");
//        Thread thread2 = new Thread(mySynchronize, "B");
//
//        thread1.start();
//        thread2.start();
//        //endregion

        final MySynchronize mySynchronize = new MySynchronize();
        Runnable runnable1 = new Runnable() {
            public void run() {
                mySynchronize.m4t1();
            }
        };

        Runnable runnable2 = new Runnable() {
            public void run() {
                mySynchronize.m4t2();
            }
        };

        Thread thread1 = new Thread(runnable1, "t1");
        Thread thread2 = new Thread(runnable2, "t2");

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

    public void m4t1(){
        synchronized (this){
            int i = 5;
            while (i-- > 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e){

                }
            }
        }
    }

//    //region section 2
//    public void m4t2(){
//        int i = 5;
//        while (i-- > 0){
//            System.out.println(Thread.currentThread().getName()+":"+i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e){
//
//            }
//        }
//    }
//    //endregion

    //region section 3
    public void m4t2() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }
    }
    //endregion

}
