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
public class UserDetailsServiceImpl<loadUserByUsername> implements UserDetailsService{

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if(!"poojitha".equals(username)) {
//			throw new UsernameNotFoundException("Invalid user name");
//		}
//		UserDetails userDetails = User.builder().username("poojitha").password("$2a$10$JArLnUBnM0IqsGrH.ptdCe6CjF1TOIwCZFWFpEo/ryi9Ko7xfbkEC")
//  
//				.roles("ADMIN","USER").build();
//		return userDetails;
//	}
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserBean userBean = userRepository.findByUsername(username);
		if(userBean==null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		String []roles=userBean.getRoles().stream().map(r->r.getRoleName()).toArray(String[]::new);
		UserDetails userDetails = User.builder().username(userBean.getUsername()).password(userBean.getPassword()).roles(roles).build();
		return userDetails;
	}

	
}
