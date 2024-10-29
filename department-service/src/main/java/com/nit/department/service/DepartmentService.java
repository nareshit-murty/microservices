package com.nit.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.department.entity.Department;
import com.nit.department.exception.DepartmentNotFoundException;
import com.nit.department.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department getDepartment(Long id) throws DepartmentNotFoundException {
		Optional<Department> optDept = departmentRepository.findById(id);
		if (optDept.isPresent()) return optDept.get();
		throw new DepartmentNotFoundException("Department not found!!");
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public Department saveDepartment(Department dept) {
		return departmentRepository.save(dept);
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
}
