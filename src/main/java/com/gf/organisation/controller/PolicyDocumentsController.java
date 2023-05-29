package com.gf.organisation.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gf.organisation.entity.PolicyDocuments;
import com.gf.organisation.service.PolicyDocumentsService;

@RestController
@RequestMapping(value = "/policy-documents")
public class PolicyDocumentsController {
    private static final Logger log = LoggerFactory.getLogger(PolicyDocumentsController.class);

    @Autowired
    private PolicyDocumentsService policyDocumentsService;

    @PostMapping( value = "/create")
    public ResponseEntity<PolicyDocuments> createPolicyDocument(@RequestBody @Valid PolicyDocuments policyDocument) {
        log.info("Received request to create a new policy document: {}", policyDocument);
        PolicyDocuments createdDocument = policyDocumentsService.createPolicyDocument(policyDocument);
        return new ResponseEntity<>(createdDocument, HttpStatus.CREATED);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<PolicyDocuments> getPolicyDocumentById(@Valid @PathVariable Long id) {
        log.info("Received request to retrieve policy document by ID: {}", id);
        Optional<PolicyDocuments> policyDocumentOptional = policyDocumentsService.getPolicyDocumentById(id);
        return policyDocumentOptional.map(document -> new ResponseEntity<>(document, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<PolicyDocuments>> getAllPolicyDocuments() {
        log.info("Received request to retrieve all policy documents");
        List<PolicyDocuments> policyDocuments = policyDocumentsService.getAllPolicyDocuments();
        if (!policyDocuments.isEmpty()) {
            return new ResponseEntity<>(policyDocuments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping( value = "/update/{id}")
    public ResponseEntity<PolicyDocuments> updatePolicyDocument( @PathVariable Long id, @RequestBody @Valid PolicyDocuments policyDocument) {
        log.info("Received request to update policy document with ID {}: {}", id, policyDocument);
        PolicyDocuments updatedDocument = policyDocumentsService.updatePolicyDocument(id, policyDocument);
        if (updatedDocument != null) {
            return new ResponseEntity<>(updatedDocument, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping( value = "/delete/{id}")
    public ResponseEntity<PolicyDocuments> deletePolicyDocument( @Valid @PathVariable Long id) {
        log.info("Received request to delete policy document with ID {}", id);
        PolicyDocuments deletedDocument = policyDocumentsService.deletePolicyDocument(id);
        if (deletedDocument != null) {
            return new ResponseEntity<>(deletedDocument, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
