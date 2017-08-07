package com.chinasofti.lexian.manager.commodityinfo.service;

import java.util.List;

import com.chinasofti.lexian.manager.category.vo.Category;
import com.chinasofti.lexian.manager.commodityinfo.vo.CommodityInfo;

public interface CommodityInfoService {
	
	 List<CommodityInfo> selectPageAllCommodity(CommodityInfo record);
	 
	 List<CommodityInfo> selectLikeAllCommodityInfo(CommodityInfo record);
	 
	 List<Category> selectFirstName(Integer type);
	 
	 List<Category> selectOtherNameByParentId(Integer type);
	 
	 int insertSelective(CommodityInfo record);
	 
	 CommodityInfo selectOneByID(Integer id);
	 
	 Category selectCategoryNameById(Integer id);
	 
	 int updateByPrimaryKeySelective(CommodityInfo record);
}
