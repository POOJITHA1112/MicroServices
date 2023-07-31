package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.RoleBean;
import com.entity.UserBean;
import com.repo.RoleRepository;
import com.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public UserBean save(UserBean userBean) {
		userBean.setPassword(passwordEncoder.encode(userBean.getPassword()));
		return userRepo.save(userBean);
	}

	@Override
	public RoleBean save2(RoleBean roleBean) {
		return roleRepository.save(roleBean);
	}

}
