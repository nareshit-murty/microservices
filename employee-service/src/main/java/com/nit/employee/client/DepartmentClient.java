package com.nit.employee.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nit.employee.exception.DepartmentNotFoundException;
import com.nit.employee.model.Department;

@FeignClient(name = "department-service")
public interface DepartmentClient {

	@GetMapping("/department/getDepartment/{id}")
	public Department getDepartment(@PathVariable Long id) throws DepartmentNotFoundException;
}
