package com.capgemini.Employee_Payroll_Project.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmpAlreadyExistsException extends RuntimeException{

    private static final Logger log = LoggerFactory.getLogger(EmpAlreadyExistsException.class);


    public EmpAlreadyExistsException(){
        super("Employee already exits");
        log.error("Employee exits");
    }

    public EmpAlreadyExistsException(String message){
        super(message);
    }
}
