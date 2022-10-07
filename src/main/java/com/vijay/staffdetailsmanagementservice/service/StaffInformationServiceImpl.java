package com.vijay.staffdetailsmanagementservice.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.vijay.staffdetailsmanagementservice.entity.StaffInformationEntity;
import com.vijay.staffdetailsmanagementservice.entity.UserInfomation;
import com.vijay.staffdetailsmanagementservice.repository.StaffInformationRepository;

@Service
public class StaffInformationServiceImpl implements StaffInformationService{
	
	@Autowired
	private StaffInformationRepository staffInformationRepository;

	@Override
	public List<StaffInformationEntity> getAllStaffDetails() {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		List<StaffInformationEntity> staffInformationEntities = staffInformationRepository.findAll();
		staffInformationEntities = staffInformationEntities.stream().map(staff -> {
			staff.setsNo(atomicInteger.incrementAndGet());
			return staff;
		}).collect(Collectors.toList());
		return staffInformationEntities ;
	}

	@Override
	public void saveNewStaffDetails(StaffInformationEntity staffInformationEntity) {
		staffInformationRepository.save(staffInformationEntity);		
	}

	@Override
	public StaffInformationEntity getStaffDetailsById(Long staffId) {
		return staffInformationRepository.findById(staffId).get();
		
	}

	@Override
	public void deleteStaffInformationById(Long staffId) {
		staffInformationRepository.deleteById(staffId);
		
	}

	@Override
	public UserInfomation getUserInformation() {
		UserInfomation userInfo = new UserInfomation();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		userInfo.setLoggedInUserName(authentication.getName());
		return userInfo;
	}
	

}
