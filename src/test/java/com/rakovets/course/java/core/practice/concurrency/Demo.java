package com.rakovets.course.java.core.practice.concurrency;

import com.rakovets.course.java.core.practice.concurrency.jobs.Consumer;
import com.rakovets.course.java.core.practice.concurrency.supplier.Producer;

import java.util.Queue;
import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Queue<Integer> queueContainer = new LinkedBlockingQueue<>();

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2);

        Future<?> future = executor.submit(new Producer(queueContainer));
        future.get();

        executor.execute(new Consumer(queueContainer));
        executor.execute(new Consumer(queueContainer));
        executor.execute(new Consumer(queueContainer));

        executor.shutdown();
    }
}
