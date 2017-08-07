package com.chinasofti.lexian.manager.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.lexian.manager.user.dao.UserMapper;
import com.chinasofti.lexian.manager.user.service.UserService;
import com.chinasofti.lexian.manager.user.vo.User;
@Service
public class UserServiceImpl implements UserService{
	
	private UserMapper userMapper;
	
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	@Override
	public int updateUserStatus(User user) {
		int num=this.userMapper.updateByPrimaryKeySelective(user);
		return num;
	}

	@Override
	public List<User> selectPageLikeAllUser(User user) {
		List<User> userList=this.userMapper.selectPageLikeAllUser(user);
		return userList;
	}

	@Override
	public List<User> selectPageAllUser(User user) {
		List<User> userList=this.userMapper.selectPageAllUser(user);
		return userList;
	}


	@Override
	public int updatePassword(User user) {
		int num = this.userMapper.updatePasswordByPhone(user);
		return num;
	}

}
