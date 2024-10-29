package com.nit.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.employee.EmployeeServiceApplication;
import com.nit.employee.entity.Employee;
import com.nit.employee.exception.DepartmentNotFoundException;
import com.nit.employee.exception.EmployeeNotFoundException;
import com.nit.employee.model.Response;
import com.nit.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getEmployee/{id}")
	public Response getEmployee(@PathVariable Long id) throws EmployeeNotFoundException, DepartmentNotFoundException {
		return employeeService.getEmployee(id);
	}
	@GetMapping("/")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee emp){
		return employeeService.saveEmployee(emp);
	}
}
