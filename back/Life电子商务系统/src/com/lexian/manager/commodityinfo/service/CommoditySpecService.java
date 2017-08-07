package com.chinasofti.lexian.manager.commodityinfo.service;

import java.util.List;

import com.chinasofti.lexian.manager.commodityinfo.vo.CommoditySpec;

public interface CommoditySpecService {
	
	List<CommoditySpec> selectCommoditySpecByCommodityNo(String commodityNo);
	
	int insertSelective(CommoditySpec record);
	
	int deleteByPrimaryKey(Integer specid);
}
