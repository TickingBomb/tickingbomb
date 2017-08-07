package com.chinasofti.lexian.manager.user.dao;

import java.util.List;

import com.chinasofti.lexian.manager.user.vo.User;


public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
	List<User> selectPageLikeAllUser(User user);
	
	List<User> selectPageAllUser(User user);
	
	int updatePasswordByPhone(User user);
}