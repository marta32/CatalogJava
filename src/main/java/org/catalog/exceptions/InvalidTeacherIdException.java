package org.catalog.exceptions;

public class InvalidTeacherIdException extends RuntimeException{
    public InvalidTeacherIdException(String message) {
        super(message);
    }
}
