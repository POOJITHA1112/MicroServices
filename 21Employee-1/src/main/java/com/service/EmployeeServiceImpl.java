package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dto.DepartmentDto;
import com.dto.EmployeeDto;
import com.dto.ResponseDto;
import com.entity.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public ResponseDto getById(Long eid) {
		ResponseDto responseDto = new ResponseDto();
       Employee employee = employeeRepository.findById(eid).get();
       
       System.out.println(employee);
       EmployeeDto employeeDto = EmployeeDto.builder().eid(employee.getEid()).ename(employee.getEname()).email(employee.getEmail()).build();
       System.out.println(employeeDto);
       
       ResponseEntity<DepartmentDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8080/department/findById/" + employee.getDepartmentId() ,
                DepartmentDto.class);
        

        DepartmentDto departmentDto = responseEntity.getBody();

        System.out.println("333333333333");
        System.out.println(departmentDto);
        
        System.out.println(responseEntity.getStatusCode());

        responseDto.setEmployeeDto(employeeDto);
        responseDto.setDepartmentDto(departmentDto);
        System.out.println(responseDto);
        return responseDto;
	}


	@Override
	public List<Employee> findAll() {
		 ResponseDto responseDto=new ResponseDto();
		 List<Employee> employee = employeeRepository.findAll();
		return employee;
	}
	

}
