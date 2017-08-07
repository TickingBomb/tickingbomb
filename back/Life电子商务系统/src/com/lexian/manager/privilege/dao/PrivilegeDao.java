package com.chinasofti.lexian.manager.privilege.dao;

import java.util.List;

import com.chinasofti.lexian.manager.privilege.vo.LoginVo;

public interface PrivilegeDao {
	public List<String> getUrl(int userId);
	
	
	public LoginVo login(LoginVo loginVo);
 
	 
	public List<String> findAllRole(String managerId);
	 
}
