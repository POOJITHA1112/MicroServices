package com.service;

import java.util.List;

import com.entity.Department;

public interface DepartmentService {
	
	public Department save(Department department);
	
	List<Department>getAll();
	
	Department getById(Long did);

}
