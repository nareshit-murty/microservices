package com.nit.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
