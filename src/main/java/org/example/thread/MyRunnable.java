package org.example.thread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("当前的线程" + t);
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        /*
         * run和start区别 run还是再主线程执行
         */
        // myThread.run();
    }
}
