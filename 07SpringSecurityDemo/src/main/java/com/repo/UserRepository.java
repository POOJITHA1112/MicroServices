package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.UserBean;

public interface UserRepository extends JpaRepository<UserBean, Long> {
	
	public UserBean findByUserName(String UserName);

}
