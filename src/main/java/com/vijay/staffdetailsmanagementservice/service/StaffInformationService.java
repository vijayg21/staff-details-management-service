package com.vijay.staffdetailsmanagementservice.service;

import java.util.List;

import com.vijay.staffdetailsmanagementservice.entity.StaffInformationEntity;

public interface StaffInformationService {

	List<StaffInformationEntity> getAllStaffDetails();

	void saveNewStaffDetails(StaffInformationEntity staffInformationEntity);

	StaffInformationEntity getStaffDetailsById(Long staffId);

	void deleteStaffInformationById(Long staffId);

}
