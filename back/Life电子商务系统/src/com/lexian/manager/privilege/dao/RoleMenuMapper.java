package com.chinasofti.lexian.manager.privilege.dao;

import com.chinasofti.lexian.manager.privilege.vo.RoleMenuKey;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(RoleMenuKey key);

    int insert(RoleMenuKey record);

    int insertSelective(RoleMenuKey record);
}