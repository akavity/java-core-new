package com.rakovets.course.java.core.practice.concurrency;

import com.rakovets.course.java.core.practice.concurrency.jobs.Consumer;
import com.rakovets.course.java.core.practice.concurrency.supplier.Producer;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queueContainer = new LinkedBlockingQueue<>();

        Thread producer = new Thread(new Producer(queueContainer));
        Thread consumer1 = new Thread(new Consumer(queueContainer));
        Thread consumer2 = new Thread(new Consumer(queueContainer));
        Thread consumer3 = new Thread(new Consumer(queueContainer));

        producer.start();
        producer.join();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
