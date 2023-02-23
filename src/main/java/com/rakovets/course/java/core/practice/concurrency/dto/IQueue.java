package com.rakovets.course.java.core.practice.concurrency.dto;

public interface IQueue {
    void put(int i);
    Integer take();
    boolean  isEmpty();
}
