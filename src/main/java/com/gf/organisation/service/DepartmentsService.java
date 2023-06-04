package com.gf.organisation.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.gf.organisation.entity.Departments;

public interface DepartmentsService {

	Departments createDepartments(@Valid Departments departments);

	Optional<Departments> getByDepartmentId(@Valid Long id);

	List<Departments> getAllDepartments();

	Departments updateDepartments( Long id, @Valid Departments departments);

	Departments deletedDepartmentsById(@Valid long id);
}
