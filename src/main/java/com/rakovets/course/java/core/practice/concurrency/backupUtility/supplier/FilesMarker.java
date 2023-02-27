package com.rakovets.course.java.core.practice.concurrency.backupUtility.supplier;

import java.io.File;
import java.util.Queue;

public class FilesMarker implements Runnable {
    private final Queue<File> queue;
    private final String directory;

    public FilesMarker(Queue<File> queue, String directory) {
        this.queue = queue;
        this.directory = directory;
    }

    @Override
    public void run() {
        File dir = new File(directory);
        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                queue.add(item);
                System.out.println("file " + item.getName() + " has added in Queue");
            }
        } else {
            System.out.println("It's not directory");
        }
    }
}
