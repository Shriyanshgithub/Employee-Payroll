package com.capgemini.Employee_Payroll_Project.controller;

import com.capgemini.Employee_Payroll_Project.dto.EmployeeDto;
import com.capgemini.Employee_Payroll_Project.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") long id){

    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeEntity employeeEntity){

    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeEntity employeeEntity){

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") long id){
        
    }
}
