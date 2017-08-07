package com.chinasofti.lexian.manager.commodityinfo.dao;

import java.util.List;

import com.chinasofti.lexian.manager.commodityinfo.vo.CommoditySpec;

public interface CommoditySpecMapper {
    int deleteByPrimaryKey(Integer specid);

    int insert(CommoditySpec record);

    int insertSelective(CommoditySpec record);

    CommoditySpec selectByPrimaryKey(Integer specid);

    int updateByPrimaryKeySelective(CommoditySpec record);

    int updateByPrimaryKey(CommoditySpec record);
    
    List<CommoditySpec> selectCommoditySpecByCommodityNo(String commodityNo);
}