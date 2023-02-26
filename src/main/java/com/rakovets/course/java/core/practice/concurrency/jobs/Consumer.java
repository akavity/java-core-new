package com.rakovets.course.java.core.practice.concurrency.jobs;

import com.rakovets.course.java.core.practice.concurrency.utils.FileUtil;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        FileUtil file = new FileUtil("test.txt");
        Integer number = null;
        while ((number = queue.peek()) != null) {
            Integer sleepTime = queue.poll();
            sleep(sleepTime);
            System.out.println(sleepTime + " slept");
            file.write(" - I slept " + sleepTime + " second(s)");
        }
        System.out.println(" 1 second slept");
        file.write(" ...");
        sleep(1);
    }

    private void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
