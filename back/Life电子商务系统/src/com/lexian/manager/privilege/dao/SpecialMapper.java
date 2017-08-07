package com.chinasofti.lexian.manager.privilege.dao;

import com.chinasofti.lexian.manager.privilege.vo.Special;

public interface SpecialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Special record);

    int insertSelective(Special record);

    Special selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Special record);

    int updateByPrimaryKey(Special record);
}