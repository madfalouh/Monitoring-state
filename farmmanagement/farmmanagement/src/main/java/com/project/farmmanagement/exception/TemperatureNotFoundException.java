package com.project.farmmanagement.exception;

public class TemperatureNotFoundException extends RuntimeException{
    public TemperatureNotFoundException(String message){
        super(message);
    }
}
