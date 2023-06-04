package com.gf.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gf.organisation.entity.CategoryPolicy;

@Repository

public interface CategoryPolicyRepository extends JpaRepository<CategoryPolicy, Long> {

}
