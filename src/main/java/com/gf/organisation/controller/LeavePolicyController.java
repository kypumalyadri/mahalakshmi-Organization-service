package com.gf.organisation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.gf.organisation.entity.LeavePolicy;
import com.gf.organisation.service.LeavePolicyService;

@RestController
@RequestMapping("/LeavePolicy")
@CrossOrigin(origins = "*")
public class LeavePolicyController {

    private static final Logger log = LoggerFactory.getLogger(LeavePolicyController.class);

    @Autowired
    private LeavePolicyService leavePolicyService;

    @PostMapping(value = "/save")
    public ResponseEntity<LeavePolicy> createLeavePolicyEntity(@Valid @RequestBody LeavePolicy leavePolicy) {
        log.info("Creating Leave Policy: {}", leavePolicy);
        LeavePolicy createdLeavePolicy = leavePolicyService.createLeavePolicy(leavePolicy);
        log.info("Leave Policy created: {}", createdLeavePolicy);
        return new ResponseEntity<>(createdLeavePolicy, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<LeavePolicy>> getByLeavePolicyId(@Valid @PathVariable Long id) {
        log.info("Fetching Leave Policy with ID: {}", id);
        Optional<LeavePolicy> leavePolicy = leavePolicyService.getByLeavepolicyId(id);
        if (leavePolicy.isPresent()) {
            log.info("Leave Policy found: {}", leavePolicy.get());
            return new ResponseEntity<>(leavePolicy, HttpStatus.OK);
        } else {
            log.info("Leave Policy not found with ID: {}", id);
            return new ResponseEntity<>(leavePolicy, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<LeavePolicy>> getAllLeavePolicy() {
        log.info("Fetching all Leave Policies");
        List<LeavePolicy> leavePolicyList = leavePolicyService.getAllLeavePolicy();
        if (!leavePolicyList.isEmpty()) {
            log.info("Leave Policies found: {}", leavePolicyList);
            return new ResponseEntity<>(leavePolicyList, HttpStatus.OK);
        } else {
            log.info("No Leave Policies found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LeavePolicy> updateLeavePolicy(@Valid @PathVariable Long id, @RequestBody LeavePolicy leavePolicy) {
        log.info("Updating Leave Policy with ID: {}", id);
        LeavePolicy updatedLeavePolicy = leavePolicyService.updateLeavePolicy(id, leavePolicy);
        if (updatedLeavePolicy != null) {
            log.info("Leave Policy updated: {}", updatedLeavePolicy);
            return new ResponseEntity<>(updatedLeavePolicy, HttpStatus.OK);
        } else {
            log.info("Failed to update Leave Policy with ID: {}", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LeavePolicy> deleteLeavePolicy(@Valid @PathVariable Long id) {
        log.info("Deleting Leave Policy with ID: {}", id);
        LeavePolicy deletedLeavePolicy = leavePolicyService.deleteLeavePolicy(id);
        if (deletedLeavePolicy != null) {
            log.info("Leave Policy deleted: {}", deletedLeavePolicy);
            return new ResponseEntity<>(deletedLeavePolicy, HttpStatus.OK);
        } else {
            log.info("Failed to delete Leave Policy with ID: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
