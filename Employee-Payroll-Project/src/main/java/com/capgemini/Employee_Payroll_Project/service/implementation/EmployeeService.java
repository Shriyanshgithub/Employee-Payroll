package com.capgemini.Employee_Payroll_Project.service.implementation;

import com.capgemini.Employee_Payroll_Project.dto.EmployeeDto;
import com.capgemini.Employee_Payroll_Project.dto.EmployeeDtoMapper;
import com.capgemini.Employee_Payroll_Project.entity.EmployeeEntity;
import com.capgemini.Employee_Payroll_Project.repository.EmployeeRepository;
import com.capgemini.Employee_Payroll_Project.service.IEmployeeService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto addEmployee(EmployeeEntity employeeEntity) {
        EmployeeEntity employee = employeeRepository.save(employeeEntity);
        return EmployeeDtoMapper.mapToEmployeeDto(employeeEntity);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow();
        return EmployeeDtoMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto patchEmployee(EmployeeEntity employeeEntity) {
        EmployeeEntity employee = employeeRepository.save(employeeEntity);
        return EmployeeDtoMapper.mapToEmployeeDto(employee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }
}
