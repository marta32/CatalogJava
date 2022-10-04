package org.catalog.exceptions;

public class InvalidBirthdayException extends RuntimeException {

    public InvalidBirthdayException(String message) {
        super(message);
    }
}