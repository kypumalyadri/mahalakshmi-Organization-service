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

import com.gf.organisation.entity.CategoryPolicy;
import com.gf.organisation.service.CategoryPolicyService;

@RestController
@RequestMapping(value = "/policy-documents")
public class CategoryPolicyController {
    private static final Logger log = LoggerFactory.getLogger(CategoryPolicyController.class);

    @Autowired
    private CategoryPolicyService categoryPolicyService;

    @PostMapping( value = "/create")
    public ResponseEntity<CategoryPolicy> createPolicyDocument(@RequestBody @Valid CategoryPolicy policyDocument) {
        log.info("Received request to create a new policy document: {}", policyDocument);
        CategoryPolicy createdDocument = categoryPolicyService.createPolicyDocument(policyDocument);
        return new ResponseEntity<>(createdDocument, HttpStatus.CREATED);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<CategoryPolicy> getPolicyDocumentById(@Valid @PathVariable Long id) {
        log.info("Received request to retrieve policy document by ID: {}", id);
        Optional<CategoryPolicy> policyDocumentOptional = categoryPolicyService.getPolicyDocumentById(id);
        return policyDocumentOptional.map(document -> new ResponseEntity<>(document, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CategoryPolicy>> getAllPolicyDocuments() {
        log.info("Received request to retrieve all policy documents");
        List<CategoryPolicy> categoryPolicy = categoryPolicyService.getAllPolicyDocuments();
        if (!categoryPolicy.isEmpty()) {
            return new ResponseEntity<>(categoryPolicy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping( value = "/update/{id}")
    public ResponseEntity<CategoryPolicy> updatePolicyDocument( @PathVariable Long id, @RequestBody @Valid CategoryPolicy policyDocument) {
        log.info("Received request to update policy document with ID {}: {}", id, policyDocument);
        CategoryPolicy updatedDocument = categoryPolicyService.updatePolicyDocument(id, policyDocument);
        if (updatedDocument != null) {
            return new ResponseEntity<>(updatedDocument, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping( value = "/delete/{id}")
    public ResponseEntity<CategoryPolicy> deletePolicyDocument( @Valid @PathVariable Long id) {
        log.info("Received request to delete policy document with ID {}", id);
        CategoryPolicy deletedDocument = categoryPolicyService.deletePolicyDocument(id);
        if (deletedDocument != null) {
            return new ResponseEntity<>(deletedDocument, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
