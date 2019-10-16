
  package com.counsellingmanagement.service;
  
  import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.BadCredentialsException;

//import java.util.ArrayList; import java.util.Arrays;
  
  
  import org.springframework.stereotype.Service;
  
  @Service
  public class SessionManagement {
	  public static void checkSession(HttpServletRequest req) {
			
			if(req.getCookies()==null)
				  throw new BadCredentialsException("invalid session");
			for (Cookie element : req.getCookies()) {
				  if(element.equals("abcd")) {
				  }
				  else {
					  throw new BadCredentialsException("invalid session");
				  }
			}
		}

  }
 