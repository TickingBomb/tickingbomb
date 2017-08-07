package com.chinasofti.lexian.manager.privilege.dao;

import com.chinasofti.lexian.manager.privilege.vo.Specialcommodity;

public interface SpecialcommodityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Specialcommodity record);

    int insertSelective(Specialcommodity record);

    Specialcommodity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Specialcommodity record);

    int updateByPrimaryKey(Specialcommodity record);
}