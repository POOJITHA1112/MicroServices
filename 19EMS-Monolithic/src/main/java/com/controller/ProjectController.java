package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ProjectDto;
import com.entity.Project;
import com.repository.ProjectRepository;
import com.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping
	public Project save(@RequestBody ProjectDto projectDto) {
		return projectService.save(projectDto);
	
	}
	
	@GetMapping
	public List<Project>findAll(){
		return projectService.findAll();
	}
	
	@PutMapping
	public Project update(@RequestBody ProjectDto projectDto) {
		return projectService.update(projectDto);
	}
	
	@DeleteMapping("/pdelete/{pid}")
	public String delete(@PathVariable Long pid) {
		projectService.delete(pid);
		return "deleted successfully";
	}
	
	@GetMapping("/findById/{pid}")
	public Project findById(@PathVariable Long pid) {
		return projectService.getById(pid);
	}
}
