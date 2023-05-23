package com.organisation.service.Service;

import java.util.List;
import java.util.Optional;

import com.organisation.service.entity.Organisation;

import jakarta.validation.Valid;

public interface OrganisationService {

	Organisation createOrganization(Organisation organisation);

	Optional<Organisation> getOrganizationById(Long id);

	List<Organisation> getAllOrganizations();

	Organisation updateOrganization(Organisation organization);

	Organisation deletebyOrganization(@Valid Long id);

}
