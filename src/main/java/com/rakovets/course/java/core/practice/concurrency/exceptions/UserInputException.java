package com.rakovets.course.java.core.practice.concurrency.exceptions;

public class UserInputException extends RuntimeException {
    public UserInputException(String massage) {
        super(massage);
    }
}
