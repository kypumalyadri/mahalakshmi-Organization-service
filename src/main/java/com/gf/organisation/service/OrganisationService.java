package com.gf.organisation.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.gf.organisation.entity.Organisation;



public interface OrganisationService {

	Organisation createOrganisation(@Valid Organisation organisation);

	Optional<Organisation> getOrganisationById(@Valid Long id);

	List<Organisation> getAllOrganisations();

	Organisation updateOrganisation(@Valid Organisation organization);

	Organisation deletebyOrganisation(@Valid Long id);

}
