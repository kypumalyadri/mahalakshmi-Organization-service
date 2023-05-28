package com.gf.organisation.serviceImpl;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.organisation.entity.Organisation;
import com.gf.organisation.repository.OrganisationRepo;
import com.gf.organisation.service.OrganisationService;



@Service

public class OrganisationImpl implements OrganisationService {
	@Autowired
	private OrganisationRepo organisationRepo;

	@Override
	public List<Organisation> getAllOrganisations() {
		List<Organisation> organizations = organisationRepo.findAll();
		if (!organizations.isEmpty()) {
			return organizations;
		} else {

			return Collections.emptyList();
		}
	}
	@Override

	public Organisation createOrganisation(@Valid Organisation organisation) {

		return organisationRepo.save(organisation);
	}
@Override
	public Optional<Organisation> getOrganisationById(@Valid Long id) {
		Optional<Organisation> organization = organisationRepo.findById(id);
		if (organization.isPresent()) {
			return organization;
		} else {

			return Optional.empty();
		}
	}
@Override
public Organisation updateOrganisation(@Valid Organisation organization) {
    Organisation updatedOrganization = organisationRepo.save(organization);
    if (updatedOrganization != null) {
        return updatedOrganization;
    } else {
        
        throw new RuntimeException("Failed to update organization");
    }
}

@Override
public Organisation deletebyOrganisation(@Valid Long id) {
    Optional<Organisation> organisationOptional = organisationRepo.findById(id);
    if (organisationOptional.isPresent()) {
        Organisation organisation = organisationOptional.get();
        organisationRepo.delete(organisation);
        return organisation;
    } else {
        
        throw new IllegalArgumentException("Organization not found for ID: " + id);
    }
}

}
