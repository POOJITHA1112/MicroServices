package com.service;


import java.util.List;

import com.dto.ResponseDto;
import com.entity.Employee;

public interface EmployeeService {

	
	public Employee save(Employee employee);
	public ResponseDto getById(Long eid);
	public List<Employee> findAll();
}
