package com.service;

import java.util.List;

import com.dto.ProjectDto;
import com.entity.Project;

public interface ProjectService {
	
	public List<Project>findAll();
	public Project save(ProjectDto projectDto);
	public Project update(ProjectDto projectDto);
	public void delete(Long pid);
	public Project getById(Long pid);

}
