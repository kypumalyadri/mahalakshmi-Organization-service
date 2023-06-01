package com.gf.organisation.serviceImpl;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gf.organisation.entity.Business;
import com.gf.organisation.repository.BusinessRepository;
import com.gf.organisation.service.BusinessService;





@Service
@Transactional
public class BusinessServiceImpl implements BusinessService {
	@Autowired
    private final BusinessRepository businessRepository;

    public BusinessServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public Business createBusiness(@Valid Business business) {
        return businessRepository.save(business);
    }

    @Override
    public Business getBusinessById(@Valid	Long id) {
        Optional<Business> business = businessRepository.findById(id);
        return business.orElse(null);
    }

    @Override
    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    @Override
    public Business updateBusiness(@Valid Long id, Business business) {
        Optional<Business> existingBusiness = businessRepository.findById(id);
        if (existingBusiness.isPresent()) {
            business.setId(id);
            return businessRepository.save(business);
        }
        return null;
    }

    @Override
    public Business deleteBusiness(@Valid Long id) {
        Optional<Business> existingBusiness = businessRepository.findById(id);
        if (existingBusiness.isPresent()) {
            Business business = existingBusiness.get();
            businessRepository.deleteById(id);
            return business;
        }
        return null;
    }
}
