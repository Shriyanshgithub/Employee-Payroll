package com.capgemini.Employee_Payroll_Project.service;

import com.capgemini.Employee_Payroll_Project.dto.EmployeeDto;
import com.capgemini.Employee_Payroll_Project.entity.EmployeeEntity;

public interface IEmployeeService {
    EmployeeDto addEmployee(EmployeeEntity employeeEntity);
    EmployeeDto getEmployee(Long id);
    EmployeeDto patchEmployee(EmployeeEntity employeeEntity);
    boolean deleteEmployee(Long id);
}
