package com.gf.organisation.service;

import java.util.List;

import javax.validation.Valid;

import com.gf.organisation.entity.Business;



public interface BusinessService {
    Business createBusiness(@Valid Business business);
    
    Business getBusinessById(@Valid Long id);
    
    List<Business> getAllBusinesses();
    
    Business updateBusiness(Long id, @Valid Business business);
    
    Business deleteBusiness(@Valid Long id);
}

