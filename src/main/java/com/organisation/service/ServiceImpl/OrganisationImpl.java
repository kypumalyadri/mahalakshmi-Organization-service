package com.organisation.service.ServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organisation.service.Repository.OrganisationRepo;
import com.organisation.service.Service.OrganisationService;
import com.organisation.service.entity.Organisation;

import jakarta.validation.Valid;

@Service

public  class OrganisationImpl implements OrganisationService {
	@Autowired
	private OrganisationRepo organisationRepo;

	@Override
	public List<Organisation> getAllOrganizations() {
		List<Organisation> organizations = organisationRepo.findAll();
		if (!organizations.isEmpty()) {
			return organizations;
		} else {

			return Collections.emptyList();
		}
	}
	@Override

	public Organisation createOrganization(Organisation organisation) {

		return organisationRepo.save(organisation);
	}
@Override
	public Optional<Organisation> getOrganizationById(Long id) {
		Optional<Organisation> organization = organisationRepo.findById(id);
		if (organization.isPresent()) {
			return organization;
		} else {

			return Optional.empty();
		}
	}
@Override
public Organisation updateOrganization(Organisation organization) {
    Organisation updatedOrganization = organisationRepo.save(organization);
    if (updatedOrganization != null) {
        return updatedOrganization;
    } else {
        
        throw new RuntimeException("Failed to update organization");
    }
}

@Override
public Organisation deletebyOrganization(@Valid Long id) {
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
