package com.gf.organisation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gf.organisation.entity.OrganisationInfo;
import com.gf.organisation.service.OrganisationInfoService;

@RestController
@RequestMapping("/organisations")
public class OrganisationInfoController {
    private static final String CORS_ORIGIN = "*";
    private final Logger logger = LoggerFactory.getLogger(OrganisationInfoController.class);

    @Autowired
    private OrganisationInfoService organisationService;

    @PostMapping("/save")
    @CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<OrganisationInfo> createOrganisation(@Valid @RequestBody OrganisationInfo organisation) {
        logger.info("Creating organisation: {}", organisation);
        try {
            OrganisationInfo createdOrganisation = organisationService.createOrganisation(organisation);
            logger.info("Organisation created successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrganisation);
        } catch (Exception e) {
            logger.error("Failed to create organisation", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<Optional<OrganisationInfo>> getOrganisationById(@Valid @PathVariable Long id) {
        logger.info("Retrieving organisation by ID: {}", id);
        Optional<OrganisationInfo> organisation = organisationService.getOrganisationById(id);
        if (organisation.isPresent()) {
            logger.info("Organisation found: {}", organisation.get());
            return ResponseEntity.ok(organisation);
        } else {
            logger.info("Organisation not found for ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    @CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<List<OrganisationInfo>> getAllOrganisations() {
        logger.info("Retrieving all organisations");
        List<OrganisationInfo> organisations = organisationService.getAllOrganisations();
        logger.info("Retrieved {} organisations", organisations.size());
        return ResponseEntity.ok(organisations);
    }

    @PutMapping("/update/{id}")
    @CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<OrganisationInfo> updateOrganization(
            @PathVariable("id") Long id,
            @Valid @RequestBody OrganisationInfo updatedOrganization) {
        logger.info("Updating organisation with ID: {}", id);
        Optional<OrganisationInfo> existingOrganization = organisationService.getOrganisationById(id);
        if (existingOrganization.isPresent()) {
            updatedOrganization.setId(id);
            OrganisationInfo updatedOrganisation = organisationService.updateOrganisation(updatedOrganization);
            logger.info("Organisation updated successfully");
            return ResponseEntity.ok(updatedOrganisation);
        } else {
            logger.info("Organisation not found for ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<OrganisationInfo> deleteOrganisation(@Valid @PathVariable Long id) {
        logger.info("Deleting organisation with ID: {}", id);
        Optional<OrganisationInfo> organisation = organisationService.getOrganisationById(id);
        if (organisation.isPresent()) {
            organisationService.deletebyOrganisation(id);
            logger.info("Organisation deleted successfully");
            return ResponseEntity.ok(organisation.get());
        } else {
            logger.info("Organisation not found for ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }
}
