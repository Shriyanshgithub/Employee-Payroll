package com.capgemini.Employee_Payroll_Project.dto;

import com.capgemini.Employee_Payroll_Project.entity.EmployeeEntity;

public class EmployeeDtoMapper {
    public static EmployeeDto mapToEmployeeDto(EmployeeEntity employeeEntity){
        return new EmployeeDto(employeeEntity.getName(),employeeEntity.getSalary());
    }

    public static EmployeeEntity mapToEmployeeEntity(EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeDto.name());
        employeeEntity.setSalary(employeeDto.salary());
        return employeeEntity;
    }
}
