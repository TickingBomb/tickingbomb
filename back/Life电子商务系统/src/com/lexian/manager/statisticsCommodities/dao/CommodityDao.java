package com.chinasofti.lexian.manager.statisticsCommodities.dao;

import java.util.List;

import com.chinasofti.lexian.manager.statisticsCommodities.vo.Commodity;


public interface CommodityDao {
	public List<Commodity> selectPageCommodity(Commodity commodity);
	public List<Commodity> selectStorename();
	public List<Commodity> selectPageCommodityByCondition(Commodity commodity);
	public List<Commodity> selectPageCommodityWithPageviewByCondition(Commodity commodity);
	
	public List<Commodity> selectPageCommodityWithCommodity_no(Commodity commodity);
}
