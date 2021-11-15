package com.reviewcenter.congtrinhh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reviewcenter.congtrinhh.model.Employee;
import com.reviewcenter.congtrinhh.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		Employee savedEmployee = service.save(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = service.findAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getOne(@PathVariable("id") Long id) {
		Employee em = service.getById(id);
		return new ResponseEntity<>(em, HttpStatus.OK);
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateOne(@RequestBody Employee employee){
		Employee updatedEmp = service.update(employee);
		return new ResponseEntity<Employee>(updatedEmp, HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Object> deleteOne(@PathVariable("id") Long id) {
		service.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
