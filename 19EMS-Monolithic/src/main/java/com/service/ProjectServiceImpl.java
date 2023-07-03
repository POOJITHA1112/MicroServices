package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.ProjectDto;
import com.entity.Project;
import com.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public Project save(ProjectDto projectDto) {
		return projectRepository.save(Project.builder().pname(projectDto.getPname()).build());
	}

	@Override
	public Project update(ProjectDto projectDto) {
		return projectRepository.save(Project.builder().pid(projectDto.getPid()).pname(projectDto.getPname()).build());
	}

	@Override
	public void delete(Long pid) {
		projectRepository.deleteById(pid);
	}

	@Override
	public Project getById(Long pid) {
		return projectRepository.findById(pid).get();
	}

}
