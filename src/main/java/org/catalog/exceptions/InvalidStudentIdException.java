package org.catalog.exceptions;

public class InvalidStudentIdException extends RuntimeException{

    public InvalidStudentIdException(String message) {
        super(message);
    }
}
