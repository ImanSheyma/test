package com.imansheyma.test.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id){
        super ("employee record with id " + id + " not found");
    }

}
