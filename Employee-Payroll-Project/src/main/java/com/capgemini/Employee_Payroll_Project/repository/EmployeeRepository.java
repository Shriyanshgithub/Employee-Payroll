package com.capgemini.Employee_Payroll_Project.repository;

import com.capgemini.Employee_Payroll_Project.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity , Long> {
}
