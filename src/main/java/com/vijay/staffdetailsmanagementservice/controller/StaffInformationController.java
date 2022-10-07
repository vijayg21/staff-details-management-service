package com.vijay.staffdetailsmanagementservice.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.vijay.staffdetailsmanagementservice.entity.StaffInformationEntity;
import com.vijay.staffdetailsmanagementservice.entity.UserInfomation;
import com.vijay.staffdetailsmanagementservice.service.StaffInformationService;



@Controller
public class StaffInformationController {

	@Autowired
	private StaffInformationService staffInformationService;
	
	@GetMapping({"/stafflist", "/"})
	public ModelAndView getAllStaffs() {
		ModelAndView mav = new ModelAndView("staff-information-list");
		mav.addObject("staffList", staffInformationService.getAllStaffDetails());
		mav.addObject("userInfo", staffInformationService.getUserInformation());
		return mav;
	}
	
	@GetMapping("/addnewstaff")
	public ModelAndView addStaffForm() {
		ModelAndView mav = new ModelAndView("add-new-staff");
		mav.addObject("newStaffForm", new StaffInformationEntity());
		return mav;
	}
	
	@PostMapping("/saveStaff")
	public String saveNewStaff(@ModelAttribute StaffInformationEntity staffInformationEntity) {
		staffInformationService.saveNewStaffDetails(staffInformationEntity);
		return "redirect:/stafflist";
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long staffId) {
		ModelAndView mav = new ModelAndView("add-new-staff");
		mav.addObject("newStaffForm", staffInformationService.getStaffDetailsById(staffId));
		return mav;
	}
	
	@GetMapping("/deleteStaff")
	public String deleteStaffInformation(@RequestParam Long staffId) {
		staffInformationService.deleteStaffInformationById(staffId);
		return "redirect:/stafflist";
	}	
}
