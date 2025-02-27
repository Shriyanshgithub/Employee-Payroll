package com.capgemini.Employee_Payroll_Project.handler;

import com.capgemini.Employee_Payroll_Project.EmployeePayrollProjectApplication;
import com.capgemini.Employee_Payroll_Project.exception.EmpAlreadyExistsException;
import com.capgemini.Employee_Payroll_Project.exception.InvalidParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.InvalidClassException;


@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException exception){
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

    @ExceptionHandler(EmpAlreadyExistsException.class)
    public ResponseEntity<Object> handleEmployeeAlreadyExitException(EmpAlreadyExistsException exception){
        log.error("Employee Already exits");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<Object> InvalidParameterException(InvalidParameterException exception){
        log.error("Invalid argument or parameter");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
