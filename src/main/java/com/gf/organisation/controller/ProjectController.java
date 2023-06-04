package com.gf.organisation.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gf.organisation.entity.Project;
import com.gf.organisation.service.ProjectService;

@RestController
@RequestMapping(value = "/Project")
@CrossOrigin(origins = "*")
public class ProjectController {

	private static final Logger logger = Logger.getLogger(ProjectController.class.getName());

	@Autowired
	private ProjectService projectService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Project> createProject(@Valid @RequestBody Project project){
		logger.log(Level.INFO, "Creating a new project");
		Project createProject = projectService.createProject(project);
		return new ResponseEntity<>(createProject,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Project>> getProjectById(@PathVariable Long id){
		logger.log(Level.INFO, "Fetching project by ID: {0}", id);
		Optional<Project> project = projectService.getProjectById(id);
		if (project.isPresent()) {
			return new ResponseEntity<>(project, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(project, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Project>> getAllProjects(){
		logger.log(Level.INFO, "Fetching all projects");
		List<Project> projects = projectService.getAllProjects();
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable long id, @Valid @RequestBody Project project){
		logger.log(Level.INFO, "Updating project with ID: {0}", id);
		Project updateProject = projectService.updateProject(id, project);
		if (updateProject != null) {
			return new ResponseEntity<>(updateProject, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateProject, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Project> deleteProject(@PathVariable Long id){
		logger.log(Level.INFO, "Deleting project with ID: {0}", id);
		Project deleteProject = projectService.deleteProject(id);
		if (deleteProject != null) {
			return new ResponseEntity<>(deleteProject, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(deleteProject, HttpStatus.NO_CONTENT);
		}
	}
}
