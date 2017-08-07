package com.chinasofti.lexian.manager.user.service;

import java.util.List;

import com.chinasofti.lexian.manager.user.vo.User;


public interface UserService {
	
	int updateUserStatus(User user);
	
	List<User> selectPageAllUser(User user);

	List<User> selectPageLikeAllUser(User user);
	
	int updatePassword(User user);
	
	
}
