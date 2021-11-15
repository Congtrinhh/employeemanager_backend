package com.reviewcenter.congtrinhh.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewcenter.congtrinhh.exception.UserNotFoundException;
import com.reviewcenter.congtrinhh.model.Employee;
import com.reviewcenter.congtrinhh.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> findAll(){
		return repository.findAll();
	}
	
	public Employee save(Employee em) {
		em.setCode(UUID.randomUUID().toString());
		return repository.save(em);
	}
	
	public Employee update(Employee em) {
		return repository.save(em);
	}
	
	public Employee getById(Long id) {
		return repository.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found."));
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
