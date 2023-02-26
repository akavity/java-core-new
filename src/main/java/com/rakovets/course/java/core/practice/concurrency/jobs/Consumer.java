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
        Integer sleepTime = null;
        while ((sleepTime = queue.poll()) != null) {
            sleep(sleepTime);
            file.write(" - I slept " + sleepTime + " second(s)");
        }
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
