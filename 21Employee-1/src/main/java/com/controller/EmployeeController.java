  package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ResponseDto;
import com.entity.Employee;
import com.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee>save(@RequestBody Employee employee){
		Employee save = employeeService.save(employee);
		return new ResponseEntity<Employee>(save,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/findById/{eid}")
	public ResponseEntity<ResponseDto> findByid(@PathVariable Long eid){
		ResponseDto byId = employeeService.getById(eid);
		
		return ResponseEntity.ok(byId);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAll(){
		List<Employee> list = employeeService.findAll();
		return ResponseEntity.ok(list);
	}
	
}
