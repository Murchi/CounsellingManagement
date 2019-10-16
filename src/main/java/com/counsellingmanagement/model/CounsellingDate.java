/***Contains counselling dates and marks allowed for each day ***/

package com.counsellingmanagement.model;


import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.repository.Temporal;

@Entity
public class CounsellingDate {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	Integer id;
	
	//@Column(name ="date",columnDefinition = "DATE")
	private LocalDate date;
	int marks;
	//String studentname;
	
	CounsellingDate() {
		
	}

	public CounsellingDate(Integer id,LocalDate date, int marks)  {
		super();
		this.id=id;
		this.date = date;
		this.marks = marks;
		
		
	}
	
	public Integer getid() {
		return id;
	}
	
	public void setid(Integer id) {
		this.id=id;
	}
	
	/*
	 * public Login(String studentname) { super(); this.studentname=studentname; }
	 */
	
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	/*
	 * public String getStudent() { return studentname; }
	 * 
	 * public void setStudentnames(String studentname) {
	 * this.studentname=studentname; }
	 */
	
	
	
}
