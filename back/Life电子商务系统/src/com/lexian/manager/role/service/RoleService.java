package com.chinasofti.lexian.manager.role.service;

import java.util.List;

import com.chinasofti.lexian.manager.role.vo.Role;


public interface RoleService {
	
	public List<Role> searchPageAllRole(Role role);
	
	public List<Role> searchselectRoleInfo(Role role);
	
	public int updateByPrimaryKeySelective(Role record);
	
	public int insert(Role record);
	
}
