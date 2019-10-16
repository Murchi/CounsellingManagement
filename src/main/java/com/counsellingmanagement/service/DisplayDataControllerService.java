
  package com.counsellingmanagement.service;
  
  import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.ArrayList; import java.util.Arrays;
  
  
  import org.springframework.stereotype.Service;
  
  import com.counsellingmanagement.model.DisplayData;
import com.counsellingmanagement.repo.CollegeCourseRepo;
import com.counsellingmanagement.repo.CollegeRepo;
import com.counsellingmanagement.repo.CourseRepo;
//import com.counsellingmanagement.repo.DisplayRepo;
  
  @Service
  public class DisplayDataControllerService {
	  
	/*
	 * CollegeService collegeservice =new CollegeService();
	 * 
	 * 
	 * CourseService courseservice = new CourseService();
	 * 
	 * 
	 * CollegeCourseService collegecourse = new CollegeCourseService();
	 */
	  
	  
	/*
	 * @Autowired CollegeRepo collegerepo;
	 * 
	 * @Autowired CourseRepo courserepo;
	 * 
	 * 
	 * @Autowired CollegeCourseRepo collegecourserepo;
	 */
	  
	  
	  @Autowired
	  CollegeService collegeservice;
	  
	  @Autowired
	  CourseService courseservice;
	  
	  @Autowired
	  CollegeCourseService collegecourse;
 
	ArrayList<DisplayData>display = new ArrayList();
	
	/*** Displays College data to the user***/
	public ArrayList<DisplayData> display() {
		
		if(display.size()==0) {
			
			
			
				
			
			  System.out.println(collegeservice.getCollege().get(0).getCollegeid());
			  display.add(new DisplayData(collegeservice.getCollege().get(0).getCollegeid(),
			  collegeservice.getCollege().get(0).getCollegename(),courseservice.getCourse()
			  .get(0).getCourseid(),
			  courseservice.getCourse().get(0).getCoursename(),collegecourse.getCollegelist
			  ().get(0).getTotal_seats(),
			  collegecourse.getCollegelist().get(0).getAvalable_seats()));
			  
			
			  display.add(new
			  DisplayData(collegeservice.getCollege().get(0).getCollegeid(),
			  collegeservice.getCollege().get(0).getCollegename(),courseservice.getCourse()
			  .get(1).getCourseid(), courseservice.getCourse().get(1).getCoursename(),
			  collegecourse.getCollegelist().get(1).getTotal_seats(),
			  collegecourse.getCollegelist().get(1).getAvalable_seats()));
			  
			  display.add(new
			  DisplayData(collegeservice.getCollege().get(1).getCollegeid(),
			  collegeservice.getCollege().get(1).getCollegename(),courseservice.getCourse()
			  .get(2).getCourseid(),
			  courseservice.getCourse().get(2).getCoursename(),collegecourse.getCollegelist
			  ().get(2).getTotal_seats(),
			  collegecourse.getCollegelist().get(2).getAvalable_seats()));
			  
			  display.add(new
			  DisplayData(collegeservice.getCollege().get(1).getCollegeid(),
			  collegeservice.getCollege().get(1).getCollegename(),courseservice.getCourse()
			  .get(3).getCourseid(),
			  courseservice.getCourse().get(3).getCoursename(),collegecourse.getCollegelist
			  ().get(3).getTotal_seats(),
			  collegecourse.getCollegelist().get(3).getAvalable_seats()));
			  
			  display.add(new
			  DisplayData(collegeservice.getCollege().get(2).getCollegeid(),
			  collegeservice.getCollege().get(2).getCollegename(),courseservice.getCourse()
			  .get(4).getCourseid(),
			  courseservice.getCourse().get(4).getCoursename(),collegecourse.getCollegelist
			  ().get(4).getTotal_seats(),
			  collegecourse.getCollegelist().get(4).getAvalable_seats()));
			  
			  display.add(new
			  DisplayData(collegeservice.getCollege().get(2).getCollegeid(),
			  collegeservice.getCollege().get(2).getCollegename(),courseservice.getCourse()
			  .get(5).getCourseid(),
			  courseservice.getCourse().get(5).getCoursename(),collegecourse.getCollegelist
			  ().get(5).getTotal_seats(),
			  collegecourse.getCollegelist().get(5).getAvalable_seats()));
			  
			  display.add(new
			  DisplayData(collegeservice.getCollege().get(3).getCollegeid(),
			  collegeservice.getCollege().get(3).getCollegename(),courseservice.getCourse()
			  .get(6).getCourseid(),
			  courseservice.getCourse().get(6).getCoursename(),collegecourse.getCollegelist
			  ().get(6).getTotal_seats(),
			  collegecourse.getCollegelist().get(6).getAvalable_seats()));
			  
			  display.add(new
			  DisplayData(collegeservice.getCollege().get(3).getCollegeid(),
			  collegeservice.getCollege().get(3).getCollegename(),courseservice.getCourse()
			  .get(7).getCourseid(),
			  courseservice.getCourse().get(7).getCoursename(),collegecourse.getCollegelist
			  ().get(7).getTotal_seats(),
			  collegecourse.getCollegelist().get(7).getAvalable_seats()));
			  
			  
			  display.add(new
			  DisplayData(collegeservice.getCollege().get(4).getCollegeid(),
			  collegeservice.getCollege().get(4).getCollegename(),courseservice.getCourse()
			  .get(8).getCourseid(),
			  courseservice.getCourse().get(8).getCoursename(),collegecourse.getCollegelist
			  ().get(8).getTotal_seats(),
			  collegecourse.getCollegelist().get(8).getAvalable_seats()));
			  
			  
			  display.add(new
			  DisplayData(collegeservice.getCollege().get(4).getCollegeid(),
			  collegeservice.getCollege().get(4).getCollegename(),courseservice.getCourse()
			  .get(9).getCourseid(),
			  courseservice.getCourse().get(9).getCoursename(),collegecourse.getCollegelist
			  ().get(9).getTotal_seats(),
			  collegecourse.getCollegelist().get(9).getAvalable_seats()));
			 
			 
		return display;
		}
		else {
		return display;
		}
	
	}
	
		public ArrayList<DisplayData> display(Integer courseid) {
		
		
			for(int i=0;i<display.size();i++) {
				
				if(display.get(i).getCourseid().equals(courseid)) {
					int available= display.get(i).getAvailableseats()-1;
					display.get(i).setAvailableseats(available);
					
				}
				if(display.get(i).getAvailableseats()==0) {
					display.remove(i);
				}
			}
			
			
		
		
		return display;
	}
  
  }
 