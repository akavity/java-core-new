package com.rakovets.course.java.core.practice.concurrency;

import com.rakovets.course.java.core.practice.concurrency.dto.QueueContainer;
import com.rakovets.course.java.core.practice.concurrency.jobs.Consumer;
import com.rakovets.course.java.core.practice.concurrency.supplier.Producer;

public class Demo {
    public static void main(String[] args) {
        QueueContainer queueContainer = new QueueContainer();
        Producer producer = new Producer(queueContainer);
        Consumer consumer = new Consumer(queueContainer, "last Hope");
        Thread pr = new Thread(producer);
        Thread conThread =  new Thread(consumer);

       pr.start();
       conThread.start();
       consumer.disable();
    }
}
