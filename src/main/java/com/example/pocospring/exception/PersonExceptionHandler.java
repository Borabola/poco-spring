package com.example.pocospring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//RestControllerAdvice annotation is a combination of ControllerAdvice and Responsebody.
//Used in Java to create global exception handlers for RESTful APIs.
@RestControllerAdvice
public class PersonExceptionHandler
{
    //This method get triggered whenever there is MethodArgumentNotValidException exception.
    //It shows only the user friendly error message.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException exception)
    {
        Map<String,String>errorMap=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->
        {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }

    //This method get triggered whenever there is PersonNotFoundException exception.
    //It shows only the user friendly error message.
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PersonNotFoundException.class)
    public Map<String,String>handleUserNotFoundException(PersonNotFoundException exception)
    {
        Map<String,String>errorMap=new HashMap<>();
        errorMap.put("message",exception.getMessage());
        return errorMap;
    }
}
