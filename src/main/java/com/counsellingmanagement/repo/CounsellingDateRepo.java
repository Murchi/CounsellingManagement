package com.counsellingmanagement.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.counsellingmanagement.model.CounsellingDate;
import com.counsellingmanagement.model.Student;

public interface CounsellingDateRepo extends CrudRepository<CounsellingDate,Integer>{

	@Query(value= "select * from counselling_date where date=:id" , nativeQuery=true)
	public CounsellingDate returnCounsellingDate(@Param("id") LocalDate date);
	
	/*
	 * private ArrayList<Login>login =new ArrayList<>(Arrays.asList( new Login(new
	 * Date(2019,9,4),800), new Login(new Date(2019,9,6),600), new Login(new
	 * Date(2019,9,8),500), new Login(new Date(2019,9,9),400), new Login(new
	 * Date(2019,9,10),300) ));
	 * 
	 * public ArrayList<Login> getAllDates() { return login; }
	 */
	
	
}
