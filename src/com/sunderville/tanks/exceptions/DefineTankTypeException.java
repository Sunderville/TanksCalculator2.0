package com.sunderville.tanks.exceptions;

public class DefineTankTypeException extends Throwable {

    public DefineTankTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefineTankTypeException(String message) {
        super(message);
    }
}