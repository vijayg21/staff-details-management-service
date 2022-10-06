package com.vijay.staffdetailsmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vijay.staffdetailsmanagementservice.entity.StaffInformationEntity;

@Repository
public interface StaffInformationRepository extends JpaRepository<StaffInformationEntity,Long >{

}
