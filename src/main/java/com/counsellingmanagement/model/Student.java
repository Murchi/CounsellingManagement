/*** Contains student information ***/

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
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	Integer id;
	
	@Column(unique =true, nullable=false)
	String studentid;
	
	String name;
	//String collegeid;
	//String courseid;
	int marks;
	String password;
	
	
	@ManyToOne
	@JoinColumn(name = "selectedcourseid")
	private Course course;
	
	
	@ManyToOne
	@JoinColumn(name = "selectedcollegeid")
	private College college;
	
	public Student() {
		
	}
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password=password;
	}
	
	public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	public String getstudentid() {
		return studentid;
	}
	
	public void setstudentid(String studentid) {
		this.studentid = studentid;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college=college;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course=course;
	}
	
	

	

	public Student( Integer id,String studentid,String name,int marks, College college, Course course,String password) {
		super();
		this.college=college;
		this.course=course;
		this.id=id;
		this.studentid=studentid;
		this.marks = marks;
		this.name = name;
		this.password = password;
	}
	
}
