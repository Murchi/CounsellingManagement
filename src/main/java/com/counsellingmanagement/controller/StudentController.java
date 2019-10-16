/***Contains api for Student data ***/

package com.counsellingmanagement.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.counsellingmanagement.model.Student;
import com.counsellingmanagement.repo.StudentRepo;
import com.counsellingmanagement.service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	StudentService studentservice ;
	
	
	/*** Returns registered students information ***/
	@RequestMapping("/studentinfo")
	public ArrayList<Student>getStudentInfo() {
		return studentservice.getStudentInfo();
	}
	
	/*** Api to add new Student when registered***/
	@RequestMapping(method=RequestMethod.POST, value="/studentinfo")
	//public void addTopic(@RequestBody Student student) {
		public void addTopic(@ModelAttribute ("student") Student student) {
		studentservice.addStudent(student);
	}
	
	/*** Api to get student information by Id ***/
	@RequestMapping(method=RequestMethod.GET,value="/studentinfo/{studentid}")
	public Student chooseCollege(@PathVariable String studentid,HttpServletRequest req,ServletResponse response) {
		 HttpSession session = req.getSession();
		  String user = (String)session.getAttribute("studentid");
		  Student student =null;
		  System.out.println(user);
		  if(user !=null) {
		
			  return studentservice.returnStudent(studentid);
		  }
		  else {
			  return student;
		  }
			  
		  
		
		  //HttpServletResponse httpResponse = null;
		  //httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		  

	}
}
