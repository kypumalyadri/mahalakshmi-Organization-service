package com.gf.organisation.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.gf.organisation.entity.LeavePolicy;

public interface LeavePolicyService {
	
	LeavePolicy  createLeavePolicy(@Valid LeavePolicy leavePolicy);
	
	Optional<LeavePolicy>getByLeavepolicyId(@Valid Long id);
	
	List<LeavePolicy>getAllLeavePolicy();
	
	LeavePolicy updateLeavePolicy(@Valid Long id, LeavePolicy leavePolicy);
	
	LeavePolicy deleteLeavePolicy(@Valid Long id);

}
