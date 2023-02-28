package com.rakovets.course.java.core.practice.concurrency.backupUtility.job;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
        boolean existence = false;
        File dest = new File(directory);
        if (!dest.exists()) {
           existence = dest.mkdir();
            System.out.println("New directory has created");
        }
        File file = null;
        while ((file = queue.poll()) != null) {
            File source = new File(file.toURI());
            try {
                Files.copy(source.toPath(), dest.toPath().resolve(source.getName()), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("files " + file.getName() + " has copied in new directory");
            } catch (IOException e) {
                 e.printStackTrace();
            }
        }
    }
}
