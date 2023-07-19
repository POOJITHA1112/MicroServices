package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

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
	
}
