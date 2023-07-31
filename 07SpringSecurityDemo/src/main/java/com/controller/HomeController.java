package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserBean;
import com.service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/security")
	public String get() {
		 return "Spring security enabled";
	}
	
	
	@GetMapping("/public")
	public String Public() {
		 return "public";
		 
	}@GetMapping("/admin")
	public String admin() {
		 return "admin";
		 
	}
	@GetMapping("/user")
	public String user() {
		 return "user";
		 
	}
	
	@PostMapping("/signUp")
	public UserBean signUp(@RequestBody UserBean userBean) {
		UserBean usBean=userService.save(userBean);
		usBean.setPassword("**********");
		return usBean;
		
	}
	
}
