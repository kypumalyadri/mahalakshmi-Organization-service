package com.gf.organisation.controller;

import java.util.List;

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

import com.gf.organisation.entity.Business;
import com.gf.organisation.service.BusinessService;

import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping(value = "/businesses")
@Slf4j
@CrossOrigin(origins = "*")
public class BusinessController {

  private final BusinessService businessService;

  @Autowired
  public BusinessController(BusinessService businessService) {
    this.businessService = businessService;
  }

  @PostMapping(value = "/save")
  public ResponseEntity<Business> createBusiness( @Valid @RequestBody Business business ) {
    log.info("Creating a new business: {}", business);
    Business createdBusiness = businessService.createBusiness(business);
    log.info("New business created: {}", createdBusiness);
    return new ResponseEntity<>(createdBusiness, HttpStatus.CREATED);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Business> getBusinessById( @Valid @PathVariable Long id) {
    log.info("Retrieving business with ID: {}", id);
    Business business = businessService.getBusinessById(id);
    if (business != null) {
      log.info("Business found: {}", business);
      return new ResponseEntity<>(business, HttpStatus.OK);
    }
    log.info("Business not found with ID: {}", id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping(value = "/all")
  public ResponseEntity<List<Business>> getAllBusinesses() {
    log.info("Retrieving all businesses");
    List<Business> businesses = businessService.getAllBusinesses();
    log.info("Total businesses found: {}", businesses.size());
    return new ResponseEntity<>(businesses, HttpStatus.OK);
  }

  @PutMapping(value = "/update/{id}")
  public ResponseEntity<Business> updateBusiness( @Valid @PathVariable Long id, @RequestBody Business business) {
    log.info("Updating business with ID: {}", id);
    Business updatedBusiness = businessService.updateBusiness(id, business);
    if (updatedBusiness != null) {
      log.info("Business updated: {}", updatedBusiness);
      return new ResponseEntity<>(updatedBusiness, HttpStatus.OK);
    }
    log.info("Business not found with ID: {}", id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Business> deleteBusiness(@Valid @PathVariable Long id) {
    log.info("Deleting business with ID: {}", id);
    Business deletedBusiness = businessService.deleteBusiness(id);
    if (deletedBusiness != null) {
      log.info("Business deleted: {}", deletedBusiness);
      return new ResponseEntity<>(deletedBusiness, HttpStatus.OK);
    }
    log.info("Business not found with ID: {}", id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
