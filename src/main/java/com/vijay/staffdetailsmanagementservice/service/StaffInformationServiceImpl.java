package com.vijay.staffdetailsmanagementservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.staffdetailsmanagementservice.entity.StaffInformationEntity;
import com.vijay.staffdetailsmanagementservice.repository.StaffInformationRepository;

@Service
public class StaffInformationServiceImpl implements StaffInformationService{
	
	@Autowired
	private StaffInformationRepository staffInformationRepository;

	@Override
	public List<StaffInformationEntity> getAllStaffDetails() {
		// TODO Auto-generated method stub
		return staffInformationRepository.findAll();
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
	

}
