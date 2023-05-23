package com.organisation.service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organisation.service.entity.Organisation;

@Repository

public interface OrganisationRepo extends JpaRepository<Organisation, Long> {

}
