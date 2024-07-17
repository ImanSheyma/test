package com.imansheyma.test.exceptions;

public class OfficeNotFoundException extends RuntimeException{
    public OfficeNotFoundException(Long id){
        super ("office record with id " + id + " not found");
    }

}
