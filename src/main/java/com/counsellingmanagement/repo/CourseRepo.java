package com.counsellingmanagement.repo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.counsellingmanagement.model.College;
import com.counsellingmanagement.model.Course;
import com.counsellingmanagement.model.Student;

public interface CourseRepo extends CrudRepository<Course,Integer> {
	
	@Query(value= "select * from course where courseid=:id" , nativeQuery=true)
	public Course getCourseById(@Param("id") Integer courseid);

	/*
	 * private ArrayList<Course>course =new ArrayList<>(Arrays.asList( new
	 * Course("RV7","CSE"), new Course("RV8","ECE"), new
	 * Course("IITG1","Mechanical"), new Course("IITG2","CSE"), new
	 * Course("IITK1","IT"), new Course("IITK2","Civil"), new
	 * Course("IITH1","BioTech"), new Course("IITH2","Civil"), new
	 * Course("BITS1","CSE"), new Course("BITS2","ECE") ));
	 */

	/*
	 * public ArrayList<Course> getCourse() {
	 * 
	 * return course; }
	 */
}
