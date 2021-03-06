package com.reviewcenter.congtrinhh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewcenter.congtrinhh.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Optional<Employee> findEmployeeById(Long id);
	
	void deleteEmployeeById(Long id);
}
