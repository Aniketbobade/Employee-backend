package com.hacktech.employee.services;

import java.util.List;

import com.hacktech.employee.model.Employee;

public interface EmployeeService {
	
	Employee cerateEmployee(Employee employee);

	List<Employee> getAllEmployees();

	boolean deleteEmployee(Long id);

	Employee updateEmployee(Long id, Employee employee);

	Employee getEmployee(Long id);
}
