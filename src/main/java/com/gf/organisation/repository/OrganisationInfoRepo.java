package com.gf.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gf.organisation.entity.OrganisationInfo;

@Repository

public interface OrganisationInfoRepo extends JpaRepository<OrganisationInfo, Long> {

}
