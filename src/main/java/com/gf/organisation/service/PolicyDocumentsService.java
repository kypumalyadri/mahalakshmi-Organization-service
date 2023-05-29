package com.gf.organisation.service;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.gf.organisation.entity.PolicyDocuments;

public interface PolicyDocumentsService {
	
    PolicyDocuments createPolicyDocument(@Valid PolicyDocuments policyDocument);

    Optional<PolicyDocuments> getPolicyDocumentById(@Valid Long id);

    List<PolicyDocuments> getAllPolicyDocuments();

    PolicyDocuments updatePolicyDocument(@Valid Long id, PolicyDocuments policyDocument);

    PolicyDocuments deletePolicyDocument(@Valid Long id);
}

