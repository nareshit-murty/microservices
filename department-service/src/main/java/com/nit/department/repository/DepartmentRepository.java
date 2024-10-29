package com.nit.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
