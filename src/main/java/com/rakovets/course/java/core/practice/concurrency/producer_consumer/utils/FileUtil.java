package com.rakovets.course.java.core.practice.concurrency.producer_consumer.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileUtil {
    private final File file;

    public FileUtil(String fileName) {
        this.file = new File(fileName);
    }

    public void write(String text) {
        try (FileWriter writer = new FileWriter(file, true);) {
            writer.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))
                    + "-" + Thread.currentThread().getName() + text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
