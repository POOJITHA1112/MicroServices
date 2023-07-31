package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.RoleBean;
import com.entity.UserBean;
import com.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public UserBean signUp(@RequestBody UserBean userBean) {
		UserBean ub=userService.save(userBean);
		ub.setPassword("**********");
		return ub;
	}
	
	@PostMapping("/role")
	public RoleBean save(@RequestBody RoleBean roleBean) {
		RoleBean rb=userService.save2(roleBean);
		return rb;
	}
	

}
