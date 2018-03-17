package com.twu.biblioteca;

public class WrongItemIdException extends Exception{

    public WrongItemIdException(String message) {
        super(message);
    }
}
