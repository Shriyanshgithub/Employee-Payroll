package com.capgemini.Employee_Payroll_Project.service.implementation;

import com.capgemini.Employee_Payroll_Project.dto.EmployeeDto;
import com.capgemini.Employee_Payroll_Project.entity.EmployeeEntity;
import com.capgemini.Employee_Payroll_Project.service.IEmployeeService;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Override
    public EmployeeDto addEmployee(EmployeeEntity employeeEntity) {
        return null;
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        return null;
    }

    @Override
    public EmployeeDto patchEmployee(EmployeeEntity employeeEntity) {
        return null;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return false;
    }
}
