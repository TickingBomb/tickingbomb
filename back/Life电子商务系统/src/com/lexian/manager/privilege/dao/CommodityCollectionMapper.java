package com.chinasofti.lexian.manager.privilege.dao;

import com.chinasofti.lexian.manager.privilege.vo.CommodityCollection;

public interface CommodityCollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommodityCollection record);

    int insertSelective(CommodityCollection record);

    CommodityCollection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommodityCollection record);

    int updateByPrimaryKey(CommodityCollection record);
}