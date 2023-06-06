package com.gf.organisation.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gf.organisation.entity.OrganisationInfo;
import com.gf.organisation.repository.OrganisationInfoRepo;
import com.gf.organisation.service.OrganisationInfoService;

@Service
@Transactional

public class OrganisationInfoImpl implements OrganisationInfoService {
	@Autowired
	private OrganisationInfoRepo organisationRepo;

	@Override
	public List<OrganisationInfo> getAllOrganisations() {
		List<OrganisationInfo> organizations = organisationRepo.findAll();
		if (!organizations.isEmpty()) {
			return organizations;
		} else {

			return Collections.emptyList();
		}
	}

	@Override

	public OrganisationInfo createOrganisation(@Valid OrganisationInfo organisation) {

		return organisationRepo.save(organisation);
	}

	@Override
	public Optional<OrganisationInfo> getOrganisationById(@Valid Long id) {
		Optional<OrganisationInfo> organization = organisationRepo.findById(id);
		if (organization.isPresent()) {
			return organization;
		} else {

			return Optional.empty();
		}
	}

	@Override
	public OrganisationInfo updateOrganisation(@Valid OrganisationInfo organization) {
		OrganisationInfo updatedOrganization = organisationRepo.save(organization);
		if (updatedOrganization != null) {
			return updatedOrganization;
		} else {

			throw new RuntimeException("Failed to update organization");
		}
	}

	@Override
	public OrganisationInfo deletebyOrganisation(@Valid Long id) {
		Optional<OrganisationInfo> organisationOptional = organisationRepo.findById(id);
		if (organisationOptional.isPresent()) {
			OrganisationInfo organisation = organisationOptional.get();
			organisationRepo.delete(organisation);
			return organisation;
		} else {

			throw new IllegalArgumentException("Organization not found for ID: " + id);
		}
	}

}
