package com.gf.organisation.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gf.organisation.entity.LeavePolicy;
import com.gf.organisation.repository.LeavePolicyRepository;
import com.gf.organisation.service.LeavePolicyService;
@Service
@Transactional

public class LeavePolicyImpl implements LeavePolicyService {
	@Autowired
	private LeavePolicyRepository leavePolicyRepository;
	@Override
	public LeavePolicy createLeavePolicy(@Valid LeavePolicy leavePolicy) {
		return leavePolicyRepository.save(leavePolicy);
		
	}
	@Override
	public Optional<LeavePolicy>getByLeavepolicyId(@Valid Long id){
		return leavePolicyRepository.findById(id);
		

	}
	@Override
	public List<LeavePolicy>getAllLeavePolicy(){
		return leavePolicyRepository.findAll();
	}
	@Override
	public LeavePolicy updateLeavePolicy(@Valid Long id, LeavePolicy leavePolicy) {
		Optional<LeavePolicy> existingLeavePolicy = leavePolicyRepository.findById(id);
		if (existingLeavePolicy.isPresent()) {
			leavePolicy.setId(id);
			return leavePolicyRepository.save(leavePolicy);
		}
		return null;
	}
	@Override
	public LeavePolicy deleteLeavePolicy(@Valid Long id) {

		Optional<LeavePolicy> existingLeavePolicy = leavePolicyRepository.findById(id);
		if (existingLeavePolicy.isPresent()) {
			LeavePolicy leavePolicy1 = existingLeavePolicy.get();
			leavePolicyRepository.deleteById(id);
			return leavePolicy1;
		}
		return null;
	}
}
