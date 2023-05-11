package org.example.thread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("当前的线程" + t);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        /*
         * run和start区别 run还是再主线程执行
         */
        // myThread.run();

        Thread thread1 = new Thread(() -> {
            System.out.println(1);
        });
        thread1.start();
    }
}
