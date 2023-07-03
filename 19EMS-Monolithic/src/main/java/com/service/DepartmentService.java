package com.service;

import java.util.List;

import com.dto.DepartmentDto;
import com.entity.Department;

public interface DepartmentService {
	
	public List<Department>findAll();
	public Department save(DepartmentDto departmentDto);
	public Department update(DepartmentDto departmentDto);
	public void delete(Long did);
	public Department getByid(Long did);

}
