package com.chinasofti.lexian.manager.privilege.dao;

import com.chinasofti.lexian.manager.privilege.vo.Store;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}