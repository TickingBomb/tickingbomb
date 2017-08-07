package com.chinasofti.lexian.manager.privilege.dao;

import com.chinasofti.lexian.manager.privilege.vo.CommodityStore;

public interface CommodityStoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommodityStore record);

    int insertSelective(CommodityStore record);

    CommodityStore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommodityStore record);

    int updateByPrimaryKey(CommodityStore record);
}