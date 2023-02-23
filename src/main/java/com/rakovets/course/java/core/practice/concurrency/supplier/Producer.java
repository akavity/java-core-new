package com.rakovets.course.java.core.practice.concurrency.supplier;

import com.rakovets.course.java.core.practice.concurrency.dto.Queue;
import com.rakovets.course.java.core.practice.concurrency.exceptions.UserInputException;
import java.util.Scanner;


public class Producer implements Runnable {
    private Queue queue;

    public Producer() {
        this.queue = new Queue();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            if (scanner.hasNext()) {
                if (scanner.nextInt() >= 0) {
                    queue.put(scanner.nextInt());
                } else if (scanner.nextInt() == -1) {
                    scanner.close();
                }
            } else {
                throw new UserInputException("Write only positive");
            }
        } catch (UserInputException e) {
            System.out.println("Error message"  + e.getMessage());
        }
    }

    public Queue getQueue() {
        return queue;
    }
}
