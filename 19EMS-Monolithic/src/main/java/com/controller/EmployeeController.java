package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EmployeeDto;
import com.entity.Employee;
import com.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee>findAll(){
		return employeeService.findAll();
	}
	
	@PostMapping
	public Employee save(@RequestBody EmployeeDto employeeDto) {
		System.out.println(employeeDto.getDid());
		System.out.println(employeeDto.getEsal());
		System.out.println(employeeDto.getPids());
		System.out.println("//////////////////");
		
		return employeeService.save(employeeDto);
	}
	
	@PutMapping
	public Employee update(@RequestBody EmployeeDto employeeDto) {
		return employeeService.update(employeeDto);
	}
	
	@DeleteMapping("/edelete/{eid}")
	public String delete(@PathVariable Long eid) {
		return "deleted succefully";
	}
	
	@GetMapping("/findById/{eid}")
	public Employee findById(@PathVariable Long eid) {
		return employeeService.getById(eid);
	}
}
