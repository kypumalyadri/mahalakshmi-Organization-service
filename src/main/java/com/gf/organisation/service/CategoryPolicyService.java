package com.gf.organisation.service;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.gf.organisation.entity.CategoryPolicy;

public interface CategoryPolicyService {
	
    CategoryPolicy createPolicyDocument(@Valid CategoryPolicy policyDocument);

    Optional<CategoryPolicy> getPolicyDocumentById(@Valid Long id);

    List<CategoryPolicy> getAllPolicyDocuments();

    CategoryPolicy updatePolicyDocument(@Valid Long id, CategoryPolicy policyDocument);

    CategoryPolicy deletePolicyDocument(@Valid Long id);
}

