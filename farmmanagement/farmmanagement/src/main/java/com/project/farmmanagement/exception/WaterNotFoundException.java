package com.project.farmmanagement.exception;

public class WaterNotFoundException extends RuntimeException{
    public  WaterNotFoundException(String message){
        super(message);
    }
}
