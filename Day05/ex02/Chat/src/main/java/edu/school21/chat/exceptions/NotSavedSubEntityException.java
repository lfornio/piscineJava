package edu.school21.chat.exceptions;

public class NotSavedSubEntityException extends RuntimeException {
    public NotSavedSubEntityException() {
        System.out.println("Unable to add a message");
    }
}

