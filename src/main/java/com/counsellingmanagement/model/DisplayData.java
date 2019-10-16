/*** contains method to display data to student ***/

package com.counsellingmanagement.model;

import java.util.ArrayList;

public class DisplayData {
	
	
	Integer collegeid;
	String colegename;
	Integer courseid;
	String coursename;
	int total_seats;
	int available_seats;
	public DisplayData(Integer collegeid, String colegename, Integer courseid, String coursename,int total_seats,int available_seats) {
		super();
		this.collegeid = collegeid;
		this.colegename = colegename;
		this.courseid = courseid;
		this.coursename = coursename;
		this.total_seats=total_seats;
		this.available_seats=available_seats;
	}
	
	
	public int getTotalseats() {
		return total_seats;
	}
	
	public void setTotalSeats(int total_seats) {
		this.total_seats=total_seats;
	}
	
	public int getAvailableseats() {
		return available_seats;
	}
	
	public void setAvailableseats(int available_seats) {
		this.available_seats=available_seats;
	}
	
	public Integer getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}
	public String getColegename() {
		return colegename;
	}
	public void setColegename(String colegename) {
		this.colegename = colegename;
	}
	public Integer getCourseid() {
		return courseid;
	}
	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * private String collegeid; /private String collegename; //private String
	 * courseid; //private String coursename; int total_seats; int available_seats;
	 * CollegeService college; CourseService course; CollegeCourseService
	 * collegecourse; public DisplayData(int total_seats, int
	 * available_seats,CollegeService college,CourseService course,
	 * CollegeCourseService collegecourse) { super(); //this.collegeid = collegeid;
	 * //this.collegename = collegename; //this.courseid = courseid;
	 * //this.coursename = coursename; this.total_seats = total_seats;
	 * this.available_seats = available_seats; this.collegecourse=collegecourse;
	 * this.course=course; this.college=college; }
	 * 
	 * 
	 * public String getCollegeid() { return collegeid; } public void
	 * setCollegeid(String collegeid) { this.collegeid = collegeid; } public String
	 * getCollegename() { return collegename; } public void setCollegename(String
	 * collegename) { this.collegename = collegename; } public String getCourseid()
	 * { return courseid; } public void setCourseid(String courseid) { this.courseid
	 * = courseid; } public String getCoursename() { return coursename; } public
	 * void setCoursename(String coursename) { this.coursename = coursename; }
	 * 
	 * public int getTotal_seats() { return total_seats; } public void
	 * setTotal_seats(int total_seats) { this.total_seats = total_seats; } public
	 * int getAvailable_seats() { return available_seats; } public void
	 * setAvailable_seats(int available_seats) { this.available_seats =
	 * available_seats; }
	 * 
	 * ArrayList display = new ArrayList<>(); void Display() { for(int
	 * i=0;i<collegecourse.getCollegelist().size();i++) {
	 * 
	 * display.add(collegecourse.getCollegelist().get(2));
	 * display.add(collegecourse.getCollegelist().get(3));
	 * 
	 * } }
	 */

}
