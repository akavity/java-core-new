package com.rakovets.course.java.core.practice.concurrency.producer_consumer;

import com.rakovets.course.java.core.practice.concurrency.producer_consumer.jobs.Consumer;
import com.rakovets.course.java.core.practice.concurrency.producer_consumer.supplier.Producer;

import java.util.Queue;
import java.util.concurrent.*;

public class Demo2 {
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
