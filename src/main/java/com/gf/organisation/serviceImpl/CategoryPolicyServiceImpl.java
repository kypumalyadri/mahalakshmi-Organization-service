package com.gf.organisation.serviceImpl;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gf.organisation.entity.CategoryPolicy;
import com.gf.organisation.repository.CategoryPolicyRepository;
import com.gf.organisation.service.CategoryPolicyService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CategoryPolicyServiceImpl implements CategoryPolicyService {
    
    @Autowired
    private CategoryPolicyRepository categoryPolicyRepository;

    @Override
    public CategoryPolicy createPolicyDocument(@Valid CategoryPolicy policyDocument) {
        log.info("Creating a new policy document: {}", policyDocument);
        return categoryPolicyRepository.save(policyDocument);
    }

    @Override
    public Optional<CategoryPolicy> getPolicyDocumentById(@Valid Long id) {
        log.info("Retrieving policy document by ID: {}", id);
        return categoryPolicyRepository.findById(id);
    }

    @Override
    public List<CategoryPolicy> getAllPolicyDocuments() {
        log.info("Retrieving all policy documents");
        return categoryPolicyRepository.findAll();
    }

    @Override
    public CategoryPolicy updatePolicyDocument(@Valid Long id, CategoryPolicy policyDocument) {
        log.info("Updating policy document with ID {}: {}", id, policyDocument);
        Optional<CategoryPolicy> existingDocumentOptional = categoryPolicyRepository.findById(id);
        if (existingDocumentOptional.isPresent()) {
            policyDocument.setId(id);
            return categoryPolicyRepository.save(policyDocument);
        } else {
            log.warn("Policy document with ID {} not found", id);
            return null;
        }
    }

    @Override
    public CategoryPolicy deletePolicyDocument(@Valid Long id) {
        log.info("Deleting policy document with ID {}", id);
        Optional<CategoryPolicy> existingDocumentOptional = categoryPolicyRepository.findById(id);
        if (existingDocumentOptional.isPresent()) {
            CategoryPolicy policyDocument = existingDocumentOptional.get();
            categoryPolicyRepository.deleteById(id);
            return policyDocument;
        } else {
            log.warn("Policy document with ID {} not found", id);
            return null;
        }
    }
}

