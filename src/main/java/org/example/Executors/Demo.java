package org.example.Executors;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.example.thread.MyCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        说明：Executors 返回的线程池对象的弊端如下：
        1）FixedThreadPool 和 SingleThreadPool：
        允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
        2）CachedThreadPool：
        允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
        3）ScheduledThreadPool：
        允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
         */

        /*
         * executor
         * executorService
         * abstractExecutorService
         * ThreadPoolExecutor
         */

//        ExecutorService executor = Executors.newFixedThreadPool(5);
//
//        Executors.newSingleThreadExecutor();
//
//        Executors.newCachedThreadPool();
//
//        Executors.newScheduledThreadPool();

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("my-thread-%d").build();

        int corePoolSize = 4;
        int maximumPoolSize = 4;
        int keepAliveTime = 16;
        ExecutorService threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1000),
                namedThreadFactory);

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Future<String> submit = threadPool.submit(new MyCallable());
            String s = submit.get();
            strings.add(s);
        }

        System.out.println(strings);
    }
}
