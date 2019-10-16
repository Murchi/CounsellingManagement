/*** Contains information about College Course total seats and available seats ***/

package com.counsellingmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CollegeCourse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	Integer id;
	//int collegeid;
	
	int total_seats;
	int avalable_seats;
	
	@ManyToOne
	@JoinColumn(name = "collegeid")
	private College college;
	
	
	@OneToOne
	@JoinColumn(name = "courseid")
	private Course course;
	
	//int collegeid;
	//int courseid;
	
	CollegeCourse() {
		
	}
	
	

	public CollegeCourse(Integer id,College college, Course course, int total_seats, int avalable_seats) {
		super();
		
		this.id=id;
		this.college = college;
		this.course = course;
		this.total_seats = total_seats;
		this.avalable_seats = avalable_seats;
	}

	
	  
	 
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public College getCollege() {
		return college;
	}
	
	public void setCollege() {
		this.college=college;
	}

	/*
	 * public void setCollegeid(String collegeid) { this.collegeid = collegeid; }
	 */

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getTotal_seats() {
		return total_seats;
	}

	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}

	public int getAvalable_seats() {
		return avalable_seats;
	}

	public void setAvalable_seats(int avalable_seats) {
		this.avalable_seats = avalable_seats;
	}
	
	
	
}
