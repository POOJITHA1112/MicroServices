package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entity.UserBean;
import com.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserBean userBean=userRepository.findByUserName(username);
		
		if(userBean==null) {
			throw new UsernameNotFoundException("Invalis username or password");
		}
		
		String[] roles=  userBean.getRoles().stream().map(r ->r.getRoleName()).toArray(String[]::new);
		UserDetails userDetails = User.builder().username(userBean.getUserName()).password(userBean.getPassword())
				.roles(roles).build();
		return userDetails;
	}

}
