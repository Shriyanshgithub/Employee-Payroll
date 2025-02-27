package com.capgemini.Employee_Payroll_Project.controller;

import com.capgemini.Employee_Payroll_Project.dto.EmployeeDto;
import com.capgemini.Employee_Payroll_Project.entity.EmployeeEntity;
import com.capgemini.Employee_Payroll_Project.exception.EmpAlreadyExistsException;
import com.capgemini.Employee_Payroll_Project.service.implementation.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

@RestController
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") long id){
        log.info("Get employee by ID");
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody @Valid EmployeeEntity employeeEntity,
                                                    BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            for(ObjectError error : bindingResult.getAllErrors()){
                log.error(error.getDefaultMessage());
            }
            throw new EmpAlreadyExistsException("Validation failed!");
        }
        log.info("Save the employee in database");
        return new ResponseEntity<>(employeeService.addEmployee(employeeEntity),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody @Valid EmployeeEntity employeeEntity,BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.error(error.getDefaultMessage());
            }
            throw new InvalidParameterException("validation failed");
        }
        
        log.debug("update the employee details");
        return new ResponseEntity<>(employeeService.patchEmployee(employeeEntity),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") long id){
        return new ResponseEntity<>(employeeService.deleteEmployee(id),HttpStatus.OK);
    }
}
