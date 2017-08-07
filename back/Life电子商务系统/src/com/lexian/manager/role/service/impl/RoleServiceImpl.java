package com.chinasofti.lexian.manager.role.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.lexian.manager.role.dao.RoleMapper;
import com.chinasofti.lexian.manager.role.service.RoleService;
import com.chinasofti.lexian.manager.role.vo.Role;

@Service
public class RoleServiceImpl implements RoleService{
	private RoleMapper roleMapper;

	@Autowired
	public void setPrivilegeDao(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	@Override
	public List<Role> searchPageAllRole(Role role) {
		List<Role> rolelist = roleMapper.searchselectPageAllRole(role);
		return rolelist;
	}

	@Override
	public List<Role> searchselectRoleInfo(Role role ) {
		List<Role> rolelist = roleMapper.searchselectPageRoleInfo(role);
		return rolelist;
	}

	@Override
	public int updateByPrimaryKeySelective(Role role) {
		int num = roleMapper.updateByPrimaryKeySelective(role);
		return num;
	}
	
	//添加
	@Override
	public int insert(Role record){
		int ret =roleMapper.insert(record);
		return ret;
	}

}
