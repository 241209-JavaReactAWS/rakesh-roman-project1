package com.revature.project1.Exceptions;

public class ContentNotFoundException extends RuntimeException{
    public ContentNotFoundException(String message){
        super(message);
    }
}
