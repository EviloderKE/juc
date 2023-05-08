package org.example.thread;

public class MyThread extends Thread{

    @Override
    public void run(){
        //Thread t = Thread.currentThread();
        String name = getName();
        System.out.println("当前的线程" + name);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        Thread thread1 = new Thread(() -> {
            System.out.println(1);
        });
        thread1.start();
    }
}
