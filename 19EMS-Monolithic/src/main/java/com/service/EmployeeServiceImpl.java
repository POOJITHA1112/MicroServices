package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.EmployeeDto;
import com.entity.Department;
import com.entity.Employee;
import com.entity.Project;
import com.repository.DepartmentRepository;
import com.repository.EmployeeRepository;
import com.repository.ProjectRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();

	}
	

	@Override
	public Employee save(EmployeeDto employeeDto) {
		
		Department department=departmentRepository.findById(employeeDto.getDid()).get();
		List<Project>projects=projectRepository.findAllById(employeeDto.getPids());
		return employeeRepository.save(Employee.builder().ename(employeeDto.getEname()).esal(employeeDto.getEsal())
				.department(department)
				.projects(projects)
				.build());
	}


	@Override
	public Employee update(EmployeeDto employeeDto) {
		Department department=departmentRepository.findById(employeeDto.getDid()).get();
		List<Project> projects=projectRepository.findAllById(employeeDto.getPids());
		return employeeRepository.save(Employee.builder().eid(employeeDto.getEid()).ename(employeeDto.getEname()).esal(employeeDto.getEsal())
				.department(department)
				.projects(projects)
				.build()
				);
	}


	@Override
	public void delete(Long eid) {
		employeeRepository.deleteById(eid);
	}


	@Override
	public Employee getById(Long eid) {
		return employeeRepository.findById(eid).get();
	}

}
