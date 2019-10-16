package com.counsellingmanagement.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.counsellingmanagement.model.College;
import com.counsellingmanagement.repo.CollegeRepo;


@Service
public class CollegeService {
	
	@Autowired
	 CollegeRepo collegerepo ;
	
	/*
	 * private ArrayList<College>college =new ArrayList<>(Arrays.asList( new
	 * College("001","RVCollege"), new College("002","IITG"), new
	 * College("003","IITK"), new College("004","IITH"), new College("005","BITS")
	 * ));
	 */
	
	/*** Returns CollegeList ***/
	public ArrayList<College> getCollege() {
		
		//return collegerepo.getCollege();
		ArrayList<College> college = new ArrayList<College>();
		collegerepo.findAll().forEach(college::add);
		return college;
	}
	
	/*** Adds new College ***/
	public void addCollege(College college) {
		System.out.println(college.getCollegename());
		collegerepo.save(college);
	}

	
}
