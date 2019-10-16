package com.counsellingmanagement.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.counsellingmanagement.model.CounsellingDate;
import com.counsellingmanagement.model.Student;
import com.counsellingmanagement.repo.CounsellingDateRepo;


@Service
public class CounsellingDateService {
	
	@Autowired
	StudentService service ;
	
	@Autowired 
	AdminService adminservice;
	
	@Autowired
	CounsellingDateRepo repo ;
	
	/*** Return all Couonselling dates ***/
	public ArrayList getAllDates() {
		ArrayList<CounsellingDate>login = new ArrayList<CounsellingDate>();
		repo.findAll().forEach(login::add);
		return login;
	}
	
	
	/*** Add a new Counsellingdate ***/
	public void addCounsellingDate(CounsellingDate login) {
		repo.save(login);
	}
	
	
	/*** Return counsellingdate by today's date ***/
	public CounsellingDate returnCounsellingDate(LocalDate date) {
		  return repo.returnCounsellingDate(LocalDate.now());
	  }
	
	
	//CounsellingDate validatedate = repo.returnCounsellingDate(LocalDate.now());
	
	/*** Method to validate Admin Login ***/
	public String validateAdminLogging(String adminid,String password) {
		if(adminservice.returnAdmin(adminid)== null) {
			return "Admin login Unsuccessfull";
		}
		
		if(adminservice.returnAdmin(adminid).getadminid().equals(adminid) && adminservice.returnAdmin(adminid).getPassword().equals(password)) {
			return "Successfull";
		}
		
		else {
			return "Admin login Unsuccessfull";
		}
	}
	
	/*** Method to validate Student Login ***/
	public int validatelogindata(String studentid,String password) {
		/*
		 * if(validatedate==null) { return 103; }
		 */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		
	if(service.returnStudent(studentid)== null) {
		return 100;
	}
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	if(service.returnStudent(studentid).getstudentid().equals(studentid) && encoder.matches(password, service.returnStudent(studentid).getPassword())) {
		String psw =  service.returnStudent(studentid).getPassword();
		//service.returnStudent(studentid).getPassword().equals(passwordEncoder)
	
		
		return 101;
	}

	else {
		return 102;
	}
		
		
}
	
	
	
	
}
