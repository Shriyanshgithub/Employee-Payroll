package com.capgemini.Employee_Payroll_Project.service.implementation;

import com.capgemini.Employee_Payroll_Project.EmployeePayrollProjectApplication;
import com.capgemini.Employee_Payroll_Project.dto.EmployeeDto;
import com.capgemini.Employee_Payroll_Project.dto.EmployeeDtoMapper;
import com.capgemini.Employee_Payroll_Project.entity.EmployeeEntity;
import com.capgemini.Employee_Payroll_Project.repository.EmployeeRepository;
import com.capgemini.Employee_Payroll_Project.service.IEmployeeService;
import jakarta.persistence.Entity;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService implements IEmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto addEmployee(EmployeeEntity employeeEntity) {
        log.info("Add employee in database");
        EmployeeEntity employee = employeeRepository.save(employeeEntity);
        return EmployeeDtoMapper.mapToEmployeeDto(employeeEntity);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        log.info("Get employee from database");
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow();
        return EmployeeDtoMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto patchEmployee(EmployeeEntity employeeEntity) {
        log.info("update the employee details in database");
        EmployeeEntity employee = employeeRepository.save(employeeEntity);
        return EmployeeDtoMapper.mapToEmployeeDto(employee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        log.info("Delete the employee from database");
        employeeRepository.deleteById(id);
        return true;
    }
}
