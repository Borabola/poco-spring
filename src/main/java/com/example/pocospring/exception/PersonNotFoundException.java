package com.example.pocospring.exception;

public class PersonNotFoundException extends Throwable {
//public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String exception)
    {
        super(exception);
    }
}
