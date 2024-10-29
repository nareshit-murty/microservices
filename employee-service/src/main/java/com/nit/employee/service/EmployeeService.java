package com.nit.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.nit.employee.client.DepartmentClient;
import com.nit.employee.entity.Employee;
import com.nit.employee.exception.DepartmentNotFoundException;
import com.nit.employee.exception.EmployeeNotFoundException;
import com.nit.employee.model.Department;
import com.nit.employee.model.Response;
import com.nit.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	//private final RestTemplate restTemplate;
	private final DepartmentClient departmentClient;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Response getEmployee(Long id) throws EmployeeNotFoundException, DepartmentNotFoundException{
		Response response =  new Response();
		Employee emp =null;
		Optional<Employee> optEmp = employeeRepository.findById(id);
		if (optEmp.isPresent()) {
			emp = optEmp.get();
			response.setEmp(emp);
		}else
			throw new EmployeeNotFoundException("Employee is not found!!");
		//Department dept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/getDepartment/"+emp.getDeptId(), Department.class);
		Department dept = departmentClient.getDepartment(emp.getDeptId());
		response.setDept(dept);
		return response;
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public Employee saveEmployee(Employee emp){
		return employeeRepository.save(emp);
	}
}
