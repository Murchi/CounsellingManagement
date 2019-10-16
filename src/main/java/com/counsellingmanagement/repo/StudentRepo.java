package com.counsellingmanagement.repo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.counsellingmanagement.model.College;
import com.counsellingmanagement.model.Student;


public interface StudentRepo extends CrudRepository<Student,Integer> {
	
	@Query(value= "select * from student where studentid=:id" , nativeQuery=true)
	public Student returnStudent(@Param("id") String studentid);
	
	@Query(value= "select * from student where studentid=:id AND college IS NOT NULL" , nativeQuery=true)
	public Student returnCollegeStudent(@Param("id") String studetid);
		

	/*
	 * private ArrayList<Student>studentdata = new ArrayList<>(Arrays.asList( //new
	 * Student(0,null,0,null,null,null), new Student(1,"Joe",600,null,null,"abcd"),
	 * new Student(2,"Jill",800,null,null,"efgh"), new
	 * Student(3,"Tim",500,null,null,"ijkl"), new
	 * Student(4,"Alison",400,null,null,"mnop"), new
	 * Student(5,"Tom",300,null,null,"qrst") ));
	 * 
	 * 
	 * 
	 * public ArrayList<Student> getStudentInfo() {
	 * 
	 * return studentdata; }
	 * 
	 * public Student returnStudent(String name) { for(int
	 * i=0;i<studentdata.size();i++) { if(studentdata.get(i).getName().equals(name))
	 * { return studentdata.get(i); } } return studentdata.get(0); }
	 */
}
