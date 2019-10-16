package com.counsellingmanagement.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.counsellingmanagement.model.CollegeCourse;
import com.counsellingmanagement.repo.CollegeCourseRepo;

@Service
public class CollegeCourseService {
	
	@Autowired
	CollegeCourseRepo repo ;
	
	@Autowired
	
	/*
	 * private ArrayList<CollegeCourse>collegecourse =new ArrayList<>(Arrays.asList(
	 * new CollegeCourse("001","RV7",30,30), new CollegeCourse("001","RV8",30,30),
	 * new CollegeCourse("002","IITG1",40,40), new
	 * CollegeCourse("002","IITG2",30,30), new CollegeCourse("003","IITK1",20,20),
	 * new CollegeCourse("003","IITK2",30,30), new
	 * CollegeCourse("004","IITH1",20,20), new CollegeCourse("004","IITH2",20,20),
	 * new CollegeCourse("005","BITS1",20,20), new
	 * CollegeCourse("005","BITS2",35,35) ));
	 */

		
	
	/*** Returns college information along with courses offered , total seats and available seats ***/
	  public ArrayList<CollegeCourse> getCollegelist() {
	  ArrayList<CollegeCourse>collegecourse = new ArrayList<CollegeCourse>();
	  repo.findAll().forEach(collegecourse::add); return collegecourse; //return
	 // repo.getCollegelist(); 
	}
	 
	 

	
	
	  /*** Adds college information along with courses offered, total seats and available seats ***/
	  public CollegeCourse addCollegeCourse(CollegeCourse collegecourse) {
	  CollegeCourse isSuccessful=repo.save(collegecourse);
	  	return isSuccessful;
	  }
	 
	 
	 
	
	
	
	/*
	 * public void updateCollegeData(String courseid) { for(int
	 * i=0;i<repo.getCollegelist().size();i++) {
	 * if(repo.getCollegelist().get(i).getCourseid().equals(courseid)) {
	 * repo.getCollegelist().get(i).setAvalable_seats(repo.getCollegelist().get(i).
	 * getAvalable_seats()-1); }
	 * 
	 * if(repo.getCollegelist().get(i).getAvalable_seats()==0) {
	 * repo.getCollegelist().remove(i); } }
	 * 
	 * }
	 */
	
	  /***Update College Data along with courses offered totalseats and available seats once the student selects course***/
	  public CollegeCourse updateCollegeData(Integer courseid) {
	  CollegeCourse collegecourse=repo.returnCollegeCourseByCourseid(courseid);
	  System.out.println(collegecourse.getAvalable_seats());
	  collegecourse.setAvalable_seats(collegecourse.getAvalable_seats()-1);
	  CollegeCourse isSuccessful=repo.save(collegecourse);
	  return isSuccessful;
	  
	  }
	 
}
