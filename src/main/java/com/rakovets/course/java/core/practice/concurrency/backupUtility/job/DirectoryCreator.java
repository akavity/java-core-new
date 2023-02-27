package com.rakovets.course.java.core.practice.concurrency.backupUtility.job;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Queue;

public class DirectoryCreator implements Runnable {
    public Queue<File> queue;
    public String directory;

    public DirectoryCreator(Queue<File> queue, String directory) {
        this.queue = queue;
        this.directory = directory;
    }

    @Override
    public void run() {
        File dest = new File(directory);
        File file = null;
        if ((file = queue.poll()) != null) {
            try {
                Files.copy(file.toPath(), dest.toPath());
                System.out.println("files " + file.getName() + " has copied in new directory" );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
