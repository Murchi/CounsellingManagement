/*** Service class for Student ***/

package com.counsellingmanagement.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.counsellingmanagement.model.College;
import com.counsellingmanagement.model.Course;
import com.counsellingmanagement.model.Student;
import com.counsellingmanagement.repo.CollegeCourseRepo;
import com.counsellingmanagement.repo.CollegeRepo;
import com.counsellingmanagement.repo.CourseRepo;
import com.counsellingmanagement.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private CollegeCourseService collegecourseservice;
	
	//private String collegeid;
	
	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private CollegeRepo collegerepo;
	
	@Autowired
	private CourseRepo courserepo;
	
	@Autowired
	private CollegeCourseRepo collegecourserepo;
	
	/*
	 * private ArrayList<Student>studentdata = new ArrayList<>(Arrays.asList( new
	 * Student(1,"Joe",600,null,null), new Student(2,"Jill",800,null,null), new
	 * Student(3,"Tim",500,null,null), new Student(4,"Alison",400,null,null), new
	 * Student(5,"Tom",300,null,null) ));
	 */

	/*** Returns list of registered Students ***/
	public ArrayList<Student> getStudentInfo() {
		ArrayList<Student> listofstudent = new ArrayList<Student>();
		repo.findAll().forEach(listofstudent::add);
		return listofstudent;
	}

	/*** Adds a new Student ***/
	public void addStudent(Student student) {
		//repo.getStudentInfo().add(student);
		String password = student.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		student.setPassword(hashedPassword);
		System.out.println(student.getstudentid());
		repo.save(student);
	}
	
	
	  /*** Returns student by id ***/
	  public Student returnStudent(String studentid) { 
		  //return repo.returnStudent(name);
		 return repo.returnStudent(studentid);	  
	  }
	 
	  public Student returnCollegeStudent(String studentid) {
		  return repo.returnCollegeStudent(studentid);
	  }
	
	
	/*
	 * public void updateStudentData(String name ,String courseid) { for(int
	 * i=0;i<collegecourseservice.getCollegelist().size();i++) {
	 * if(collegecourseservice.getCollegelist().get(i).getCourseid().equals(courseid
	 * )) { collegeid = collegecourseservice.getCollegelist().get(i).getCollegeid();
	 * } } for(int i=0;i<repo.getStudentInfo().size();i++) {
	 * if(repo.getStudentInfo().get(i).getName().equals(name)) {
	 * repo.getStudentInfo().get(i).setCourseid(courseid);
	 * repo.getStudentInfo().get(i).setCollegeid(collegeid);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * }
	 */
	  
	 /*** Update StudentData once student selects a course ***/
	 public int updateStudentData(String studentid, Integer courseid) {
		
		 
		 Integer collegeid=collegecourserepo.returnCollegeCourseByCourseid(courseid).getCollege().getCollegeid();
		 College college = collegerepo.getCollegeById(collegeid);
		 Course course = courserepo.getCourseById(courseid);
		
		 Student student=repo.returnStudent(studentid);
		 if(student.getCollege()== null) {
		 
		student.setCollege(college);
		student.setCourse(course);
		repo.save(student);
		return 101;
		 }
		 else {
			 return 100;
		 }
		 
		 
	 }
	 
	

}
