package com.chinasofti.lexian.manager.privilege.dao;

import com.chinasofti.lexian.manager.privilege.vo.RolePrivilege;

public interface RolePrivilegeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePrivilege record);

    int insertSelective(RolePrivilege record);

    RolePrivilege selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePrivilege record);

    int updateByPrimaryKey(RolePrivilege record);
}