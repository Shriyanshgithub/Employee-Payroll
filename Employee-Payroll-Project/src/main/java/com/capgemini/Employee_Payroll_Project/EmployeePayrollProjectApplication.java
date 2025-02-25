package com.capgemini.Employee_Payroll_Project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EmployeePayrollProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(EmployeePayrollProjectApplication.class);

	public static void main(String[] args) {
         log.info("Start Employee Payroll app");
		SpringApplication.run(EmployeePayrollProjectApplication.class, args);

	}

}
