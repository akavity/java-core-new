package com.rakovets.course.java.core.practice.concurrency.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    private final File file;
    private String fileName;

    public FileUtil(String fileName) {
        this.file = new File(fileName);
    }

    public void write(String  text) {
        try {
            FileWriter writer = new FileWriter(file,true);
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
