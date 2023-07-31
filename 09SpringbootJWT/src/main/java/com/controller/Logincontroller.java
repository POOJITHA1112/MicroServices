package com.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.LoginReqBean;
import com.bean.LoginResponseBean;
import com.jwt.JwtTokenUtil;
import com.service.UserDetailsServiceImpl;

@RestController
public class Logincontroller {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@PostMapping("/signin")
	public ResponseEntity<?>login(@RequestBody LoginReqBean loginReqBean){
//		authenticate(loginReqBean.getUsername(), loginReqBean.getPassword());
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReqBean.getUsername(), loginReqBean.getPassword()));
		
		UserDetails userDetails=userDetailsServiceImpl.loadUserByUsername(loginReqBean.getUsername());
		String token = jwtTokenUtil.generateToken(userDetails);
		LoginResponseBean loginResponseBean=new LoginResponseBean(token, loginReqBean.getUsername());
		return ResponseEntity.ok(loginResponseBean);
	}
	
//	private void authenticate(String username,String password) {
//	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		
//	}
	}


