/* Contains api for accessing and modifying the College and course data together along with total and available seats */



package com.counsellingmanagement.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.counsellingmanagement.model.CollegeCourse;
import com.counsellingmanagement.model.Student;
import com.counsellingmanagement.repo.StudentRepo;
import com.counsellingmanagement.service.CollegeCourseService;
import com.counsellingmanagement.service.DisplayDataControllerService;
import com.counsellingmanagement.service.StudentService;

@RestController
public class CollegeCourseController {
	
	@Autowired
	private CollegeCourseService collegecourseservice;
	
	
	 @Autowired 
	 private StudentService studentservice;
	  
	  @Autowired 
	  private DisplayDataControllerService displayservice;
	 
	 
	  
	
	  /***Api for getting the list of college with collegeid , courseid, total_seats and available_seats***/
	  @RequestMapping("/choosecollege") public
	  ArrayList<CollegeCourse>getCollegelist() { return
	  collegecourseservice.getCollegelist(); }
	 
	
	
	  /***Api for adding college with collegeid , courseid, total_seats and available_seats***/
	  @RequestMapping(method=RequestMethod.POST, value="/addcollegecourse") 
	  public void addTopic(@RequestBody CollegeCourse collegecourse) {
	  collegecourseservice.addCollegeCourse(collegecourse); }
	 

	  /***Api to select college from available college ***/
	  @RequestMapping(method=RequestMethod.GET,value="/choosecollege/{courseid}")
	  public @ResponseBody int chooseCollege( @PathVariable Integer courseid,HttpServletRequest req,ServletResponse response) {
		  
		  HttpSession session = req.getSession();
		  String studentid = (String)session.getAttribute("studentid");
		  System.out.println(studentid);
		  if(studentid !=null) {
		  		  
				  int isSuccess=studentservice.updateStudentData(studentid,courseid);
				  System.out.println(isSuccess);
				  if(isSuccess==101) {
				  CollegeCourse isSuccessful=collegecourseservice.updateCollegeData(courseid);
				  	if(isSuccessful !=null) {
				  			displayservice.display(courseid);
				  			return isSuccess;
				  	}
				  	else {
				  			isSuccess =102;
				  			return isSuccess;
				  		}
				  }
				  else {
					  return isSuccess;
				  }
		  
			  }
			  else {
				  return 600;
			  }
		  
		  	
		  }
	  
	  
	  //return 1;
	  
	  
	  //}




	
}
