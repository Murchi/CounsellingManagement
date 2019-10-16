/*** Contains information about College ***/

package com.counsellingmanagement.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity

public class College {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "collegeid", unique = true, nullable = false)
	Integer collegeid;
	
	@Column(name ="collegename",nullable=false)
	String collegename;
	
	
	
	College() {
		
	}
	
	 @OneToMany(mappedBy="college",cascade = CascadeType.ALL)
	 private Set<CollegeCourse> collegecourse;
	
	 
	 @OneToMany(mappedBy="college",cascade = CascadeType.ALL)
	 private Set<Student> student;
	 
	 
	 
	public College(Integer collegeid,String collegename) {
		super();
		this.collegeid = collegeid;
		this.collegename = collegename;
	}
	
	public Integer getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	
	
}
