package com.rakovets.course.java.core.practice.concurrency.dto;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Queue implements IQueue {
    BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    @Override
    public void put(int i) {
        try {
            queue.put(i);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Integer take() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
