package com.gf.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gf.organisation.entity.Departments;

@Repository

public interface DepartmentsRepository extends JpaRepository<Departments, Long> {

}
