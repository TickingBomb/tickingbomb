package com.chinasofti.lexian.manager.privilege.dao;

import com.chinasofti.lexian.manager.privilege.vo.Trolley;

public interface TrolleyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trolley record);

    int insertSelective(Trolley record);

    Trolley selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Trolley record);

    int updateByPrimaryKey(Trolley record);
}