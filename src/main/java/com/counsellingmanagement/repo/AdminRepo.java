package com.counsellingmanagement.repo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.counsellingmanagement.model.Admin;
import com.counsellingmanagement.model.Student;

public interface AdminRepo extends CrudRepository<Admin,Integer> {
	
	@Query(value= "select * from admin where adminid=:id" , nativeQuery=true)
	public Admin returnAdmin(@Param("id") String adminid);

	/*
	 * private ArrayList<Admin>admindata = new ArrayList<>(Arrays.asList( new
	 * Admin("Anil","abcd")
	 * 
	 * ));
	 */

	/*
	 * public ArrayList<Admin> getAdminInfo() { return admindata; }
	 */
	
	
	

}
