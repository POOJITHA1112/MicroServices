package com.service;

import java.util.List;

import com.dto.DepartmentDto;
import com.dto.EmployeeDto;
import com.entity.Department;
import com.entity.Employee;

public interface EmployeeService {

	public List<Employee>findAll();
	
	public Employee save(EmployeeDto employeeDto);
	
	public Employee update(EmployeeDto employeeDto);
	public void delete(Long eid);
	public Employee getById(Long eid);
}
