package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/hello")
	public String get() {
		return "hello world";
	}
	
	@GetMapping("/security")
	public String secure() {
		 return "Spring security enabled";
	}
	

}
