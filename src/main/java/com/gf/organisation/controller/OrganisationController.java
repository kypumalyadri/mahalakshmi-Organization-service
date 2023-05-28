package com.gf.organisation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.gf.organisation.entity.Organisation;
import com.gf.organisation.service.OrganisationService;



@RestController
@RequestMapping("/organisations")

public class OrganisationController {
	private static final String CORS_ORIGIN = "*";

    @Autowired
    private OrganisationService organisationService;

    @PostMapping("/save")
    @CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<Organisation> createOrganisation(@Valid @RequestBody Organisation organisation) {
        try {
            Organisation createdOrganisation = organisationService.createOrganisation(organisation);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrganisation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



    @GetMapping("/{id}")
	@CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<Optional<Organisation>> getOrganisationById(@Valid @PathVariable Long id) {
        Optional<Organisation> organisation = organisationService.getOrganisationById(id);
        if (organisation.isPresent()) {
            return ResponseEntity.ok(organisation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
	@CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<List<Organisation>> getAllOrganisations() {
        List<Organisation> organisations = organisationService.getAllOrganisations();
        return ResponseEntity.ok(organisations);
    }

    @PutMapping("/update/{id}")
    @CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<Organisation> updateOrganization(
            @PathVariable("id") Long id,
            @Valid @RequestBody Organisation updatedOrganization) {
        Optional<Organisation> existingOrganization = organisationService.getOrganisationById(id);
        if (existingOrganization.isPresent()) {
            updatedOrganization.setId(id);
            Organisation updatedOrganisation = organisationService.updateOrganisation(updatedOrganization);
            return ResponseEntity.ok(updatedOrganisation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
	@CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<Organisation> deleteOrganisation(@Valid @PathVariable Long id) {
        Optional<Organisation> organisation = organisationService.getOrganisationById(id);
        if (organisation.isPresent()) {
            organisationService.deletebyOrganisation(id);
            return ResponseEntity.ok(organisation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
