/*
 * package com.counsellingmanagement.service;
 * 
 * import java.util.ArrayList;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.stereotype.Service;
 * 
 * import com.counsellingmanagement.model.Student; import
 * com.counsellingmanagement.model.StudentUser; import
 * com.counsellingmanagement.repo.StudentRepo;
 * 
 * public class JwtUserDetailsService implements UserDetailsService {
 * 
 * @Autowired private StudentRepo repo;
 * 
 * @Autowired private PasswordEncoder bcryptEncoder;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { if ("javainuse".equals(username)) { return new
 * User("javainuse",
 * "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new
 * ArrayList<>()); } else { throw new
 * UsernameNotFoundException("User not found with username: " + username); } }
 * 
 * public StudentRepo save(Student user) { Student newUser = new Student();
 * newUser.setstudentid(user.getstudentid());
 * 
 * newUser.setPassword(bcryptEncoder.encode(user.getPassword())); return
 * (StudentRepo) repo.save(newUser); }
 * 
 * }
 */