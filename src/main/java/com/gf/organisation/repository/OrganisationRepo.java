package com.gf.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gf.organisation.entity.Organisation;

@Repository

public interface OrganisationRepo extends JpaRepository<Organisation, Long> {

}
