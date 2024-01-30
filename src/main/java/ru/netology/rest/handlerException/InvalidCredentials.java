package ru.netology.rest.handlerException;

public class InvalidCredentials extends NullPointerException{
    public InvalidCredentials(String message) {
        super(message);
    }
}
