package com.gf.organisation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gf.organisation.entity.Departments;
import com.gf.organisation.service.DepartmentsService;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "*")
public class DepartmentsController {
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentsController.class);
	
	@Autowired
	private DepartmentsService departmentsService;

	@PostMapping("/create")
	public ResponseEntity<String> createDepartment(@RequestBody @Valid Departments department) {
		log.info("Creating department: {}", department);
		departmentsService.createDepartments(department);
		log.info("Department created successfully");
		return ResponseEntity.ok("Department created successfully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Departments>> getByDepartmentId(@Valid Long id) {
		log.info("Retrieving department by ID: {}", id);
		Optional<Departments> departmentsOptional = departmentsService.getByDepartmentId(id);

		if (departmentsOptional.isPresent()) {
			Departments departments = departmentsOptional.get();
			log.info("Department found: {}", departments);
			return ResponseEntity.ok(departmentsOptional);
		} else {
			log.info("Department not found with ID: {}", id);
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/all")
	public ResponseEntity<List<Departments>> getAllDepartments() {
		log.info("Retrieving all departments");
		List<Departments> departments = departmentsService.getAllDepartments();
		log.info("Total departments found: {}", departments.size());
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Departments> updateDepartments(@Valid @RequestBody Departments departments) {
		log.info("Updating department: {}", departments);
		Departments updatedDepartments = departmentsService.updateDepartments(departments);
		log.info("Department updated: {}", updatedDepartments);
		return new ResponseEntity<>(updatedDepartments, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Departments> deletedDepartmentsById(@Valid Long id) {
		log.info("Deleting department by ID: {}", id);
		Optional<Departments> departments = departmentsService.getByDepartmentId(id);
		if (departments.isPresent()) {
			departmentsService.deletedDepartmentsById(id);
			log.info("Department deleted: {}", departments.get());
			return ResponseEntity.ok(departments.get());
		} else {
			log.info("Department not found with ID: {}", id);
			return ResponseEntity.notFound().build();
		}
	}

}
