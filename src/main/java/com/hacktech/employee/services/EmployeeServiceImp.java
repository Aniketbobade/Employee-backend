package com.hacktech.employee.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hacktech.employee.entity.EmployeeEntity;
import com.hacktech.employee.model.Employee;
import com.hacktech.employee.repos.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	 private final EmployeeRepo employeeRepo;

	    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
	        this.employeeRepo = employeeRepo;
	    }

	@Override
	public Employee cerateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		EmployeeEntity employeeEntity=new EmployeeEntity();
		employeeEntity.setId(employee.getId());
		employeeEntity.setFirstName(employee.getFirstName());
		employeeEntity.setLastName(employee.getLastName());
		employeeEntity.setEmail(employee.getEmail());
		employeeRepo.save(employeeEntity);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeEntity> employeEntites = employeeRepo.findAll();
		List<Employee> employees = null;
		if (employeEntites != null) {
		   employees = employeEntites.stream()
		            .map(emp -> new Employee(
		                    emp.getId(),
		                    emp.getFirstName(),
		                    emp.getLastName(),
		                    emp.getEmail()))
		            .collect(Collectors.toList());
		}
		
		
		return employees;
	}

	@Override
	public boolean deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		EmployeeEntity employeeEntity= employeeRepo.findById(id).get();
		employeeRepo.delete(employeeEntity);
		return true;
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		// TODO Auto-generated method stub
		EmployeeEntity employeeEntity= employeeRepo.findById(id).get();
		employeeEntity.setEmail(employee.getEmail());
		employeeEntity.setFirstName(employee.getFirstName());
		employeeEntity.setLastName(employee.getLastName());
		employeeRepo.save(employeeEntity);
		
		return employee;
	}

	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		EmployeeEntity employeeEntity=employeeRepo.findById(id).get();
		Employee employee=new Employee();
		employee.setEmail(employeeEntity.getEmail());
		employee.setFirstName(employeeEntity.getFirstName());
		employee.setLastName(employeeEntity.getLastName());
		
		return employee;
	}

}
