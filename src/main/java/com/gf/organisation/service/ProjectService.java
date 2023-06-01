package com.gf.organisation.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.gf.organisation.entity.Project;

public interface ProjectService {
	
	Project createProject (@Valid Project project);
	
	Optional<Project>getProjectById(@Valid Long id);
	
	List<Project>getAllProjects();
	
	Project updateProject(@Valid Long id,Project project);
	
	Project deleteProject(@Valid Long id);

}
