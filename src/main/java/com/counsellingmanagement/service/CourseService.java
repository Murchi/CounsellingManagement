/*** Service class for Course ***/

package com.counsellingmanagement.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.counsellingmanagement.model.Course;
import com.counsellingmanagement.repo.CourseRepo;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepo courserepo ;
	
	/*
	 * private ArrayList<Course>course =new ArrayList<>(Arrays.asList( new
	 * Course("RV7","CSE"), new Course("RV8","ECE"), new
	 * Course("IITG1","Mechanical"), new Course("IITG2","CSE"), new
	 * Course("IITK1","IT"), new Course("IITK2","Civil"), new
	 * Course("IITH1","BioTech"), new Course("IITH2","Civil"), new
	 * Course("BITS1","CSE"), new Course("BITS2","ECE") ));
	 */
	  
	  /*** Return CourseList ***/
	  public ArrayList<Course> getCourse() {
	  
		  ArrayList<Course>courselist = new ArrayList<Course>();
		  courserepo.findAll().forEach(courselist::add);
		  return courselist;
	  }
	  
	  /*** Add a new Course ***/
	  public void addCourse(Course course) {
		  courserepo.save(course);
	  }
	 
	
}
