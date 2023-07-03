package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.DepartmentDto;
import com.entity.Department;
import com.exception.DepartmentNameNotFoundException;
import com.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Department save(DepartmentDto departmentDto) {
		
		 departmentRepository.save(Department.builder().dname(departmentDto.getDname()).dlocation(departmentDto.getDlocation()).build());
		 return null;
	}

	@Override
	public Department update(DepartmentDto departmentDto) {
		return departmentRepository.save(Department.builder().did(departmentDto.getDid()).dname(departmentDto.getDname()).dlocation(departmentDto.getDlocation()).build());
	}

	@Override
	public void delete(Long did) {
		departmentRepository.deleteById(did);
	}

	@Override
	public Department getByid(Long did) {
		Optional<Department> optional= departmentRepository.findById(did);
		if(optional.isEmpty()) {
			return null;
		}
		Department department=optional.get();
		if(department.getDname().equals("")) {
			throw new DepartmentNameNotFoundException("Department Name not found So it is an inavlid record");
		}
		return optional.get();
				
	}

}
