package org.example.thread;

import java.util.concurrent.*;

public class MyCallable implements Callable<String> {

    @Override
    public String call() {
        System.out.println(Thread.currentThread().getName() + "   执行callable的call方法");
        return "result";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
         * 使用Callable接口和FutureTask
         */
//        Callable<String> myCallable = new MyCallable();
//
//        FutureTask<String> oneTask = new FutureTask<>(myCallable);
//
//        Thread t = new Thread(oneTask);
//
//        t.start();
//
//        String s = oneTask.get();
//
//        System.out.println(s);

        /*
         * 使用线程池
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new MyCallable());
        System.out.println(submit.get());
    }
}
