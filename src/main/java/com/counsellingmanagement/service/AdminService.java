package com.counsellingmanagement.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.counsellingmanagement.model.Admin;
import com.counsellingmanagement.model.Student;
import com.counsellingmanagement.repo.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	AdminRepo repo ;
	
	/** Returns the list of configured admin ***/
	public ArrayList<Admin> getAdminInfo() {
		ArrayList<Admin>listofadmin = new ArrayList<Admin>();
		repo.findAll().forEach(listofadmin::add);
		return listofadmin;
		//return repo.getAdminInfo();
	}
	
	/** Adds and admin ***/
	public void addAdmin(Admin admin) {
		repo.save(admin);
	}
	
	/*
	 * public Optional<Admin> returnAdmin(Integer id) { return repo.findById(id); }
	 */
	
	/*** Returns Admin by id ***/
	public Admin returnAdmin(String adminid) {
		return repo.returnAdmin(adminid);
	}

}
