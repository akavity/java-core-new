package com.rakovets.course.java.core.practice.concurrency.jobs;

import com.rakovets.course.java.core.practice.concurrency.dto.Queue;
import com.rakovets.course.java.core.practice.concurrency.supplier.Producer;

public class Consumer implements Runnable {
    @Override
    public void run() {
        Queue queue = new Producer().getQueue();

       // if (!)

    }
}
