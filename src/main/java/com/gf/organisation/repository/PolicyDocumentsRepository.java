package com.gf.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gf.organisation.entity.PolicyDocuments;

@Repository

public interface PolicyDocumentsRepository extends JpaRepository<PolicyDocuments, Long> {

}
