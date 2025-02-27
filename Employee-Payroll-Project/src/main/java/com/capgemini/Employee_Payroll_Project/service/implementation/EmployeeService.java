package com.capgemini.Employee_Payroll_Project.service.implementation;

import com.capgemini.Employee_Payroll_Project.EmployeePayrollProjectApplication;
import com.capgemini.Employee_Payroll_Project.dto.EmployeeDto;
import com.capgemini.Employee_Payroll_Project.dto.EmployeeDtoMapper;
import com.capgemini.Employee_Payroll_Project.entity.EmployeeEntity;
import com.capgemini.Employee_Payroll_Project.exception.EmpAlreadyExistsException;
import com.capgemini.Employee_Payroll_Project.exception.EmployeeNotFoundException;
import com.capgemini.Employee_Payroll_Project.repository.EmployeeRepository;
import com.capgemini.Employee_Payroll_Project.service.IEmployeeService;
import jakarta.persistence.Entity;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("dev")
public class EmployeeService implements IEmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);


    EmployeeRepository employeeRepository;

    //dependency injection by constructor
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        log.trace("Bean Initialized");
        this.employeeRepository = employeeRepository;
    }

    //save the employee details in database

    @Override
    public EmployeeDto addEmployee(EmployeeEntity employeeEntity) {
        log.info("Add employee in database");
        if(employeeRepository.findById(employeeEntity.getId()).isPresent()){
            throw new EmpAlreadyExistsException();
        }
         employeeRepository.save(employeeEntity);
        return EmployeeDtoMapper.mapToEmployeeDto(employeeEntity);
    }

    //Get the employee from the database

    @Override
    public EmployeeDto getEmployee(Long id) {
        if(id < 1){
            log.warn("the id : {} is invalid",id);
            throw new IllegalArgumentException("Invalid id");
        }

        log.info("Get employee from database");
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id : " + id));
        return EmployeeDtoMapper.mapToEmployeeDto(employee);
    }

    //update the existing employee details

    @Override
    public EmployeeDto patchEmployee(EmployeeEntity employeeEntity) {
        if(employeeEntity == null){
            log.warn("Employee not found");
        }

        log.info("update the employee details in database");
        EmployeeEntity employee = employeeRepository.save(employeeEntity);
        return EmployeeDtoMapper.mapToEmployeeDto(employee);
    }

    //Delete the employee by id

    @Override
    public boolean deleteEmployee(Long id) {
        if(id < 1){
            log.info("the id : {} is invalid",id);
            throw new IllegalArgumentException("Invalid id");
        }

        log.info("Delete the employee from database by id : {}",id);
        employeeRepository.deleteById(id);
        return true;
    }
}
