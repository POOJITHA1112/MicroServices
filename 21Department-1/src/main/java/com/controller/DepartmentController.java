package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Department;
import com.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<Department>save(@RequestBody Department department){
		Department save = departmentService.save(department);
		return new ResponseEntity<Department>(save,HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Department>> getAll(){
		List<Department> list = departmentService.getAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("findById/{did}")
	public ResponseEntity<Department> findByDid(@PathVariable Long did){
		Department id = departmentService.getById(did);
		return ResponseEntity.ok(id);
	}
}
