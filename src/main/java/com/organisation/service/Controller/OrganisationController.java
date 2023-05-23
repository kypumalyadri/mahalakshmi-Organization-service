package com.organisation.service.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organisation.service.Service.OrganisationService;
import com.organisation.service.entity.Organisation;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/organizations")

public class OrganisationController {
	private static final String CORS_ORIGIN = "*";

    @Autowired
    private OrganisationService organisationService;

    @PostMapping("/save")
@CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<Organisation> createOrganization(@RequestBody Organisation organisation) {
        Organisation createdOrganisation = organisationService.createOrganization(organisation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrganisation);
    }

    @GetMapping("/{id}")
	@CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<Optional<Organisation>> getOrganisationById(@PathVariable Long id) {
        Optional<Organisation> organisation = organisationService.getOrganizationById(id);
        if (organisation.isPresent()) {
            return ResponseEntity.ok(organisation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
	@CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<List<Organisation>> getAllOrganisations() {
        List<Organisation> organisations = organisationService.getAllOrganizations();
        return ResponseEntity.ok(organisations);
    }

    @PutMapping("/update")
	@CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<Organisation> updateOrganisation(@RequestBody Organisation organisation) {
        Organisation updatedOrganisation = organisationService.updateOrganization(organisation);
        return ResponseEntity.ok(updatedOrganisation);
    }

    @DeleteMapping("/{id}")
	@CrossOrigin(origins = CORS_ORIGIN)
    public ResponseEntity<Organisation> deleteOrganisation(@PathVariable Long id) {
        Optional<Organisation> organisation = organisationService.getOrganizationById(id);
        if (organisation.isPresent()) {
            organisationService.deletebyOrganization(id);
            return ResponseEntity.ok(organisation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
