package com.chinasofti.lexian.manager.commodityinfo.service;

import java.util.List;

import com.chinasofti.lexian.manager.commodityinfo.vo.CommodityPicture;

public interface CommodityPictureService {
	
	 int deleteByPrimaryKey(Integer id);
	 
	 int insertSelective(CommodityPicture record);
	 
	 List<CommodityPicture> selectByCommodityNo(String id);
}
