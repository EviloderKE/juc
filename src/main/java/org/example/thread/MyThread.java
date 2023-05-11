package org.example.thread;

public class MyThread extends Thread{

    @Override
    public void run(){
        //Thread t = Thread.currentThread();
        String name = getName();
        System.out.println("当前的线程myThread" + name);
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
    }
}
