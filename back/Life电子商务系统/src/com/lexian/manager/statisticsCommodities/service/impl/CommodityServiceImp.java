package com.chinasofti.lexian.manager.statisticsCommodities.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.lexian.manager.statisticsCommodities.dao.CommodityDao;
import com.chinasofti.lexian.manager.statisticsCommodities.service.CommodityService;
import com.chinasofti.lexian.manager.statisticsCommodities.vo.Commodity;
@Service
public class CommodityServiceImp implements CommodityService{
	private CommodityDao commodityDao;
	public CommodityDao getCommodityDao() {
		return commodityDao;
	}
	@Autowired
	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}
	@Override
	public List<Commodity> selectPageCommodity(Commodity commodity) {
		return commodityDao.selectPageCommodity(commodity);
	}
	@Override
	public List<Commodity> selectStorename() {
		return commodityDao.selectStorename();
	}
	@Override
	public List<Commodity> selectPageCommodityWithCommodity_no(Commodity commodity) {
		return commodityDao.selectPageCommodityWithCommodity_no(commodity);
	}
	@Override
	public List<Commodity> selectPageCommodityByCondition(Commodity commodity) {
		return commodityDao.selectPageCommodityByCondition(commodity);
	}
	@Override
	public List<Commodity> selectPageCommodityWithPageviewByCondition(Commodity commodity) {
		return commodityDao.selectPageCommodityWithPageviewByCondition(commodity);
	}
	
	

}
