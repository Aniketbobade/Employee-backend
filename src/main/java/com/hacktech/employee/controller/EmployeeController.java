package com.hacktech.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.hacktech.employee.model.Employee;
import com.hacktech.employee.services.EmployeeService;

@CrossOrigin(origins = "https://644bbc3c330a2e007adcc249--sensational-douhua-a6c1ae.netlify.app/")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employees")
	Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.cerateEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
		
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		boolean deleted=false;
		deleted=employeeService.deleteEmployee(id);
		Map<String,Boolean> responce=new HashMap<>();
		responce.put("deleted",deleted);
		return ResponseEntity.ok(responce);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
		Employee employee=employeeService.getEmployee(id);
		
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
		employee=employeeService.updateEmployee(id,employee);
		
		return ResponseEntity.ok(employee);
	}
}

