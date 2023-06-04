package com.gf.organisation.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.gf.organisation.entity.OrganisationInfo;



public interface OrganisationInfoService {

	OrganisationInfo createOrganisation(@Valid OrganisationInfo organisation);

	Optional<OrganisationInfo> getOrganisationById(@Valid Long id);

	List<OrganisationInfo> getAllOrganisations();

	OrganisationInfo updateOrganisation(@Valid OrganisationInfo organization);

	OrganisationInfo deletebyOrganisation(@Valid Long id);

}
