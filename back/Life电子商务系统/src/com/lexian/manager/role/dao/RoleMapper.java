package com.chinasofti.lexian.manager.role.dao;

import java.util.List;

import com.chinasofti.lexian.manager.role.vo.Role;


public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> searchselectPageAllRole(Role role);
    
    List<Role> searchselectPageRoleInfo(Role role);
}