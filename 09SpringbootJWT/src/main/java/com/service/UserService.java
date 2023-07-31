package com.service;

import com.entity.RoleBean;
import com.entity.UserBean;

public interface UserService {
	
	public UserBean save(UserBean userBean);
	
	public RoleBean save2(RoleBean roleBean);

}
