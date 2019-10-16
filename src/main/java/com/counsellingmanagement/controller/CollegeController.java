/*Api for College Information */



package com.counsellingmanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.counsellingmanagement.model.College;
import com.counsellingmanagement.model.Student;
import com.counsellingmanagement.service.CollegeService;


@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService collegeservice ;
	
	
	//Shows total number of colleges with name and id available for counselling
	@RequestMapping("/listofcolleges")
	public ArrayList<College> getCollege() {
		return collegeservice.getCollege();
		
	}
	
	// Add a new College
	@RequestMapping(method=RequestMethod.POST, value="/addcollege")
	public @ResponseBody int addTopic(@ModelAttribute ("college") College college) {
		collegeservice.addCollege(college);
		
		return 1;
	}
	
}
