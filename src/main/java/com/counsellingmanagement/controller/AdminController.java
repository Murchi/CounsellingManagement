/* contains Api for Admin */



package com.counsellingmanagement.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.counsellingmanagement.model.Admin;
import com.counsellingmanagement.model.College;
import com.counsellingmanagement.model.CollegeCourse;
import com.counsellingmanagement.model.Student;
import com.counsellingmanagement.service.AdminService;
import com.counsellingmanagement.service.CollegeCourseService;
import com.counsellingmanagement.service.CollegeService;
import com.counsellingmanagement.service.StudentService;

@RestController
public class AdminController {
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private CollegeCourseService collegecourse;
	
	@Autowired
	private AdminService adminservice;
	
	
	
	//Show StudentData from database
	  @RequestMapping("/showStudentdata") public ArrayList<Student> getCollege() {
	  return service.getStudentInfo(); }
	 

	  //Show CollegeData from database
	  @RequestMapping("/showcollegedata") public ArrayList<CollegeCourse>
	  getCollegeList() { 
		  return collegecourse.getCollegelist(); 
		  }
	 
	
	  //Show Admin Information
	  @RequestMapping("/showadmin") public ArrayList<Admin>getAdmin() { return
	  adminservice.getAdminInfo(); }
	  
	  //Show Admin by Id
	  @RequestMapping(method=RequestMethod.GET,value="/showadmin/{adminid}") public
	  Admin chooseCollege(@PathVariable String adminid) { 
		  return adminservice.returnAdmin(adminid);
	  }
	  
	  //Add an Admin
	  @RequestMapping(method=RequestMethod.POST, value="/addadmin") public void
	  addTopic(@RequestBody Admin admin) { adminservice.addAdmin(admin); }
	 
	
}
