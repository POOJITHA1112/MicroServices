package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Department;
import com.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department getById(Long did) {
		return departmentRepository.findById(did).get(); 
	}

	@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

}
