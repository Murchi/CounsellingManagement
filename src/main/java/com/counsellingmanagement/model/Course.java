/*** Contains Course id and course name ***/

package com.counsellingmanagement.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "courseid", unique = true, nullable = false)
	Integer courseid;
	
	@Column(name ="coursename",nullable=false)
	String coursename;
	
	
	
	Course() {
		
	}

	@OneToOne(mappedBy="course",cascade = CascadeType.ALL)
	 private CollegeCourse collegecourse;
	
	@OneToMany(mappedBy="course",cascade = CascadeType.ALL)
	 private Set<Student> student;

	
	
	public Course(Integer courseid, String coursename) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
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
	
	
}
