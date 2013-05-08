package com.iweili.touch.learning;

/**
 * Created with IntelliJ IDEA.
 * User: zhouwe
 * Date: 5/8/13
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 *
 * Learning java synchronize.
 *
 * reference:
 * http://www.cnblogs.com/GnagWang/archive/2011/02/27/1966606.html
 *
 * highlight:
 * 1． 定义private 的instance变量+它的 get方法，而不要定义public/protected的instance变量。如果将变量定义为public，对象在外界可以
 *
 * 绕过同步方法的控制而直接取得它，并改动它。这也是JavaBean的标准实现方式之一。
 *
 * 2． 如果instance变量是一个对象，如数组或ArrayList什么的，那上述方法仍然不安全，因为当外界对象通过get方法拿到这个instance对象
 *
 * 的引用后，又将其指向另一个对象，那么这个private变量也就变了，岂不是很危险。 这个时候就需要将get方法也加上synchronized同步，并
 *
 * 且，只返回这个private对象的clone()――这样，调用端得到的就是对象副本的引用了
 *
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

//    //region section 3
//    public void m4t2() {
//        synchronized (this) {
//            int i = 5;
//            while (i-- > 0) {
//                System.out.println(Thread.currentThread().getName() + ":" + i);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//
//                }
//            }
//        }
//    }
//    //endregion

    //region section 4
    public synchronized void m4t2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }
    //endregion

}
