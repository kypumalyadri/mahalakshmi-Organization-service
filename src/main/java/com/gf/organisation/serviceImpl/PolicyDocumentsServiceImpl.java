package com.gf.organisation.serviceImpl;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.organisation.entity.PolicyDocuments;
import com.gf.organisation.repository.PolicyDocumentsRepository;
import com.gf.organisation.service.PolicyDocumentsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PolicyDocumentsServiceImpl implements PolicyDocumentsService {
    
    @Autowired
    private PolicyDocumentsRepository policyDocumentsRepository;

    @Override
    public PolicyDocuments createPolicyDocument(@Valid PolicyDocuments policyDocument) {
        log.info("Creating a new policy document: {}", policyDocument);
        return policyDocumentsRepository.save(policyDocument);
    }

    @Override
    public Optional<PolicyDocuments> getPolicyDocumentById(@Valid Long id) {
        log.info("Retrieving policy document by ID: {}", id);
        return policyDocumentsRepository.findById(id);
    }

    @Override
    public List<PolicyDocuments> getAllPolicyDocuments() {
        log.info("Retrieving all policy documents");
        return policyDocumentsRepository.findAll();
    }

    @Override
    public PolicyDocuments updatePolicyDocument(@Valid Long id, PolicyDocuments policyDocument) {
        log.info("Updating policy document with ID {}: {}", id, policyDocument);
        Optional<PolicyDocuments> existingDocumentOptional = policyDocumentsRepository.findById(id);
        if (existingDocumentOptional.isPresent()) {
            policyDocument.setId(id);
            return policyDocumentsRepository.save(policyDocument);
        } else {
            log.warn("Policy document with ID {} not found", id);
            return null;
        }
    }

    @Override
    public PolicyDocuments deletePolicyDocument(@Valid Long id) {
        log.info("Deleting policy document with ID {}", id);
        Optional<PolicyDocuments> existingDocumentOptional = policyDocumentsRepository.findById(id);
        if (existingDocumentOptional.isPresent()) {
            PolicyDocuments policyDocument = existingDocumentOptional.get();
            policyDocumentsRepository.deleteById(id);
            return policyDocument;
        } else {
            log.warn("Policy document with ID {} not found", id);
            return null;
        }
    }
}

