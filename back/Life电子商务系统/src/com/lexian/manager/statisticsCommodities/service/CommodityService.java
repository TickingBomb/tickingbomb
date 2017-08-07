package com.chinasofti.lexian.manager.statisticsCommodities.service;

import java.util.List;

import com.chinasofti.lexian.manager.statisticsCommodities.vo.Commodity;


public interface CommodityService {
	List<Commodity> selectPageCommodity(Commodity commodity);
	List<Commodity> selectStorename();
	List<Commodity> selectPageCommodityWithCommodity_no(Commodity commodity);
	List<Commodity> selectPageCommodityByCondition(Commodity commodity);
	List<Commodity> selectPageCommodityWithPageviewByCondition(Commodity commodity);
}
