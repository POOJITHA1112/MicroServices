package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.DepartmentDto;
import com.entity.Department;
import com.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody DepartmentDto departmentDto) {
		Department department = departmentService.save(departmentDto);
		if(department.equals("")) {
			return new ResponseEntity<>("Please fill the complete details and save the record", HttpStatus.OK);
		}
		return new ResponseEntity<Department>(department, HttpStatus.CREATED) ;
	}
	
	@GetMapping
	public ResponseEntity<?>getAll(){
		List<Department> department=departmentService.findAll();
		if(department==null) {
			return new ResponseEntity<>("Records are not present,please enter the records", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(department, HttpStatus.OK)  ;
	}
	
	@PutMapping 
	public ResponseEntity<Department> update(@RequestBody DepartmentDto departmentDto) {
		 return new ResponseEntity<>(departmentService.update(departmentDto), HttpStatus.ACCEPTED) ;
	}
	
	@DeleteMapping("/ddelete/{did}")
	public String delete(@PathVariable Long did) {
		departmentService.delete(did);
		return "deleted";
	}
	
	@GetMapping("/findById/{did}")
	public ResponseEntity<?> findById(@PathVariable Long did) {
		Department department=departmentService.getByid(did);
		if(department==null) {
			return new ResponseEntity<>("Record not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(department, HttpStatus.OK) ;
	}
}
