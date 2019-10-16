package com.counsellingmanagement.repo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.counsellingmanagement.model.College;
import com.counsellingmanagement.model.Student;

public interface CollegeRepo extends CrudRepository<College,Integer>{

	@Query(value= "select * from college where collegeid=:id" , nativeQuery=true)
	public College getCollegeById(@Param("id") Integer collegeid);
	
	/*
	 * private ArrayList<College>college =new ArrayList<>(Arrays.asList( new
	 * College("001","RVCollege"), new College("002","IITG"), new
	 * College("003","IITK"), new College("004","IITH"), new College("005","BITS")
	 * ));
	 * 
	 * public ArrayList<College>getCollege() { //return college;
	 * 
	 * }
	 */
}
