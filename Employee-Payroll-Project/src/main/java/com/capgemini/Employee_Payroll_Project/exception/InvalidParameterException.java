package com.capgemini.Employee_Payroll_Project.exception;

public class InvalidParameterException extends RuntimeException{

    public InvalidParameterException(String message){
        super(message);
    }
}
