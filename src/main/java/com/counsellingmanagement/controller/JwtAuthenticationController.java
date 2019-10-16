/*
 * package com.counsellingmanagement.controller;
 * 
 * import java.util.Objects;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.BadCredentialsException; import
 * org.springframework.security.authentication.DisabledException; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.counsellingmanagement.model.JwtRequest; import
 * com.counsellingmanagement.model.JwtResponse; import
 * com.counsellingmanagement.model.Student; import
 * com.counsellingmanagement.model.StudentUser; import
 * com.counsellingmanagement.security.config.JwtTokenUtil; import
 * com.counsellingmanagement.service.JwtUserDetailsService;
 * 
 * //@Controller
 * 
 * @RestController
 * 
 * @CrossOrigin public class JwtAuthenticationController {
 * 
 * @Autowired private AuthenticationManager authenticationManager;
 * 
 * @Autowired private JwtTokenUtil jwtTokenUtil;
 * 
 * @Autowired private JwtUserDetailsService userDetailsService;
 * 
 * @RequestMapping(value = "/authorization", method = RequestMethod.POST) public
 * ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest
 * authenticationRequest) throws Exception {
 * 
 * authenticate(authenticationRequest.getUsername(),
 * authenticationRequest.getPassword());
 * 
 * final UserDetails userDetails = userDetailsService
 * .loadUserByUsername(authenticationRequest.getUsername());
 * 
 * final String token = jwtTokenUtil.generateToken(userDetails);
 * 
 * return ResponseEntity.ok(new JwtResponse(token)); }
 * 
 * 
 * @RequestMapping(value = "/register", method = RequestMethod.POST) public
 * ResponseEntity<?> saveUser(@RequestBody Student user) throws Exception {
 * return ResponseEntity.ok(userDetailsService.save(user)); }
 * 
 * private void authenticate(String username, String password) throws Exception
 * { try { authenticationManager.authenticate(new
 * UsernamePasswordAuthenticationToken(username, password)); } catch
 * (DisabledException e) { throw new Exception("USER_DISABLED", e); } catch
 * (BadCredentialsException e) { throw new Exception("INVALID_CREDENTIALS", e);
 * } } }
 */