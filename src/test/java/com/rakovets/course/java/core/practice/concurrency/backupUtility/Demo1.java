package com.rakovets.course.java.core.practice.concurrency.backupUtility;

import com.rakovets.course.java.core.practice.concurrency.backupUtility.job.DirectoryCreator;
import com.rakovets.course.java.core.practice.concurrency.backupUtility.supplier.FilesMarker;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Queue<File> queueContainer = new LinkedBlockingQueue<>();

        Thread filesMarker = new Thread(new FilesMarker(queueContainer, "G:/home/akavity/dev/testBackupUtility"));
        Thread directoryCreator1 = new Thread(new DirectoryCreator(queueContainer, "G:/home/akavity/dev/testBackupUtility/backup"));
        Thread directoryCreator2 = new Thread(new DirectoryCreator(queueContainer, "G:/home/akavity/dev/testBackupUtility/backup"));
        Thread directoryCreator3 = new Thread(new DirectoryCreator(queueContainer, "G:/home/akavity/dev/testBackupUtility/backup"));

        filesMarker.start();
        filesMarker.join();
        directoryCreator1.start();
        directoryCreator2.start();
        directoryCreator3.start();
    }
}
