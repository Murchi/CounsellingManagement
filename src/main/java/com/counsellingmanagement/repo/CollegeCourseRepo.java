package com.counsellingmanagement.repo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.counsellingmanagement.model.CollegeCourse;
import com.counsellingmanagement.model.Student;

public interface CollegeCourseRepo extends CrudRepository<CollegeCourse,Integer> {

	@Query(value= "select * from college_course where courseid=:id" , nativeQuery=true)
	public CollegeCourse returnCollegeCourseByCourseid(@Param("id") Integer courseid);
	
	
	/*
	 * private ArrayList<CollegeCourse>collegecourse =new ArrayList<>(Arrays.asList(
	 * new CollegeCourse("001","RV7",20,20), new CollegeCourse("001","RV8",30,30),
	 * new CollegeCourse("002","IITG1",40,40), new
	 * CollegeCourse("002","IITG2",30,30), new CollegeCourse("003","IITK1",20,20),
	 * new CollegeCourse("003","IITK2",30,30), new
	 * CollegeCourse("004","IITH1",20,20), new CollegeCourse("004","IITH2",20,20),
	 * new CollegeCourse("005","BITS1",20,20), new
	 * CollegeCourse("005","BITS2",35,35) ));
	 */
	
	/*
	 * public ArrayList<CollegeCourse> getCollegelist() { return collegecourse; }
	 */

}
