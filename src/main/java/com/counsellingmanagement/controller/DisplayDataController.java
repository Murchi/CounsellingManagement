/***Api for display data ***/

package com.counsellingmanagement.controller;

import java.util.ArrayList;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.counsellingmanagement.model.DisplayData;
import com.counsellingmanagement.service.DisplayDataControllerService;
import com.counsellingmanagement.service.SessionManagement;
//import com.counsellingmanagement.service.DisplayDataControllerService;

@Controller
public class DisplayDataController {

	@Autowired
	private DisplayDataControllerService displayservice;
	
	/*** Display Course and college data  with total and available seats***/
	@RequestMapping("/display") 
	public @ResponseBody ArrayList<DisplayData>getDisplay(HttpServletRequest request,ServletResponse response) {
		
		ArrayList<DisplayData> nulldata =null;
		/*
		 * HttpSession session=request.getSession(false); String n =
		 * (String)session.getAttribute("studentid");
		 */
		//SessionManagement.checkSession(req);
	//	 Cookie[] cookie=req.getCookies();
		// for(int i =0;i<cookie.length;i++) {
			//  String string = "abcd";
			  //if(cookie[i].equals(string)) {
		 
		 		  /*if(n.equals("abcd"))*/
		HttpSession session = request.getSession();
		  String user = (String)session.getAttribute("studentid");
		  System.out.println(user);
		  if(user !=null) {
				  return displayservice.display();
		  }
		  else {
			  System.out.println(nulldata);
			  return nulldata;
		  }
			  //}
			  /*else {*/
		/*
		 * HttpServletResponse httpResponse = null;
		 * httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		 */
			 // }
		
	//}
		//return displayservice.display();
	}

}

