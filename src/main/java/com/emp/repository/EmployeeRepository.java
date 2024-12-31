package com.emp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.emp.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public Optional<Employee> findByEmail(String email);
	 public List<Employee> findByDepartment(String department);
	   
}
