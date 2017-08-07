package com.chinasofti.lexian.manager.privilege.dao;

import com.chinasofti.lexian.manager.privilege.vo.Appmanager;

public interface AppmanagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Appmanager record);

    int insertSelective(Appmanager record);

    Appmanager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appmanager record);

    int updateByPrimaryKey(Appmanager record);
}