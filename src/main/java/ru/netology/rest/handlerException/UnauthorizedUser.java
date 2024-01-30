package ru.netology.rest.handlerException;

import java.util.NoSuchElementException;

public class UnauthorizedUser extends NoSuchElementException{
    public UnauthorizedUser(String message) {
        super(message);
    }
}