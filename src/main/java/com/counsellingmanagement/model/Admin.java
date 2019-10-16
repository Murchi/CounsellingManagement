package com.counsellingmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/*** Class containing Student information ***/
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	Integer id;
	
	String adminid;
	String password;
	
	public Admin() {
		
	}

	public Admin(int id,String adminid, String password) {
		super();
		this.adminid=adminid;
		this.id = id;
		this.password = password;
	}

	public String getadminid() {
		return adminid;
	}

	public void setadminid(String adminid) {
		this.adminid = adminid;
	}

	public Integer getid() {
		return id;
	}
	
	public void setid(Integer id) {
		this.id=id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
