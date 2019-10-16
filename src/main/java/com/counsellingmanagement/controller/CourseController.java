/***Contains Api for Course ***/


package com.counsellingmanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.counsellingmanagement.model.Course;
import com.counsellingmanagement.model.Student;
import com.counsellingmanagement.service.CourseService;

@RestController
public class CourseController {
	

	@Autowired
	private CourseService courseservice;
	
	/*** Api for showing the list of courses ***/
	@RequestMapping("/listofcourses")
	public ArrayList<Course>getCourse() {
		return courseservice.getCourse();
	}
	
	
	/*** Api for adding course ***/
	@RequestMapping(method=RequestMethod.POST, value="/addcourse")
	public void addTopic(@RequestBody Course course) {
		courseservice.addCourse(course);
	}
}
