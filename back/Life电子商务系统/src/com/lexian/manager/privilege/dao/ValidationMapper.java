package com.chinasofti.lexian.manager.privilege.dao;

import com.chinasofti.lexian.manager.privilege.vo.Validation;

public interface ValidationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Validation record);

    int insertSelective(Validation record);

    Validation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Validation record);

    int updateByPrimaryKey(Validation record);
}