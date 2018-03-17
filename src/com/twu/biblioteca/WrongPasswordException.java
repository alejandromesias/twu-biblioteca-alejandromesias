package com.twu.biblioteca;

public class WrongPasswordException extends Exception{

    public WrongPasswordException(String message) {
        super(message);
    }
}
