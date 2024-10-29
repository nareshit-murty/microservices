package com.nit.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.department.entity.Department;
import com.nit.department.exception.DepartmentNotFoundException;
import com.nit.department.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/")
	public List<Department> getAllDepartments() throws DepartmentNotFoundException {
		return departmentService.getAllDepartments();
	}
	@GetMapping("/getDepartment/{id}")
	public Department getDepartment(@PathVariable Long id) throws DepartmentNotFoundException {
		return departmentService.getDepartment(id);
	}
	
	@PostMapping("/saveDepartment")
	public Department saveDepartment(@RequestBody Department dept) throws DepartmentNotFoundException {
		return departmentService.saveDepartment(dept);
	}
}
