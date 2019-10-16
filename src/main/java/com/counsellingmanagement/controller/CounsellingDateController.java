/***Counselling Date and LoginValidation Page ***/

package com.counsellingmanagement.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.HttpResource;

import com.counsellingmanagement.model.Admin;
import com.counsellingmanagement.model.CounsellingDate;
import com.counsellingmanagement.model.Student;
import com.counsellingmanagement.service.CounsellingDateService;

@Controller
//@RestController

public class CounsellingDateController {

	@Autowired
	private CounsellingDateService loginservice;

	/*
	 * @RequestMapping(value ="/index",method = RequestMethod.GET) public
	 * ModelAndView index() { ModelAndView model = new ModelAndView("index"); return
	 * model; }
	 */

	/*** Returns the index page ***/
	@RequestMapping(method = RequestMethod.GET, value = "/index")
	public String index() {
		return "index.html";
	}

	/*** Api for adding LoginDate ***/
	@RequestMapping(method = RequestMethod.POST, value = "/adddate")
	public @ResponseBody void addCounsellingDate(@RequestBody CounsellingDate login) {
		loginservice.addCounsellingDate(login);

	}

	/*
	 * @RequestMapping(method=RequestMethod.GET,value="/counsellingdates")
	 * public @ResponseBody ArrayList getAllDates() { return
	 * loginservice.getAllDates(); }
	 */

//	@RequestMapping(method=RequestMethod.POST,value="/index/studentLogin")
	// public @ResponseBody String validatelogindata(@RequestBody Student student)

	/*** Api for studentlogin validation ***/
	// @CrossOrigin(origins = "http://localhost:8067")
	 @CrossOrigin(origins = "http://192.168.1.19:8067")
	@PostMapping("/index/studentlogins")
	public @ResponseBody int validatelogindata(@ModelAttribute("student") Student student, HttpServletResponse response,
			HttpServletRequest request)

	// public @ResponseBody int validatelogindata(@RequestBody Student student)

	{
		HttpSession session = request.getSession();
		session.setAttribute("studentid", student.getstudentid());

		int loginvalidation = loginservice.validatelogindata(student.getstudentid(), student.getPassword());
		System.out.println(loginvalidation);
		return loginvalidation;
	}

	// @RequestMapping(method=RequestMethod.POST,value="/index/adminLogin")
	// public @ResponseBody String validatelogindata(@RequestBody Admin admin)

	/*** Api for admin Login validation ***/
	@CrossOrigin(origins = "http://localhost:8081")
	@PostMapping("/index/adminlogin")
	// @RequestMapping(value="/index/adminlogin",method=RequestMethod.POST)
	public @ResponseBody String adminLogin(@ModelAttribute("admin") Admin admin, HttpServletResponse response,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.setAttribute("adminid", admin.getadminid());
		String adminlogin = loginservice.validateAdminLogging(admin.getadminid(), admin.getPassword());
		return adminlogin;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/checkadminsession")
	public @ResponseBody int checkadminsession(HttpServletResponse response, HttpServletRequest request) {

		// String user= (String)session.getAttribute("studentid");
		// System.out.println("############"+user);
		if (request.getSession() != null) {
			HttpSession session = request.getSession();
			if (((String) session.getAttribute("adminid")) == null) {
				System.out.println("fail = " + (String) session.getAttribute("adminid"));
				return 100;
			} else {
				System.out.println("success = " + (String) session.getAttribute("adminid"));
				return 300;
			}
		} else {
			return 100;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/checksession")
	public @ResponseBody int checksession(HttpServletResponse response, HttpServletRequest request) {

		if (request.getSession() != null) {
			HttpSession session = request.getSession();
			if (((String) session.getAttribute("studentid")) == null) {
				System.out.println("fail = " + (String) session.getAttribute("studentid"));
				return 100;
			} else {
				System.out.println("success = " + (String) session.getAttribute("studentid"));
				return 300;
			}
		} else {
			return 100;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	public void logut(HttpServletResponse response, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		if (session.getAttribute("studentid") != null) {
			session.removeAttribute("studentid");
		} else {
			if (session.getAttribute("adminid") != null) {
				session.removeAttribute("admintid");
			}
		}
		session.invalidate();
	}

}
