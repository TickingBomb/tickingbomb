package com.chinasofti.lexian.manager.commodityinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.lexian.manager.category.vo.Category;
import com.chinasofti.lexian.manager.commodityinfo.dao.CommodityInfoMapper;
import com.chinasofti.lexian.manager.commodityinfo.service.CommodityInfoService;
import com.chinasofti.lexian.manager.commodityinfo.vo.CommodityInfo;


@Service
public class CommodityInfoServiceImpl implements CommodityInfoService{
	
	private CommodityInfoMapper commodityInfoMapper;
	
	@Autowired
	public void setcommodityInfoMapper(CommodityInfoMapper commodityInfoMapper) {
		this.commodityInfoMapper = commodityInfoMapper;
	}

	@Override
	public List<CommodityInfo> selectPageAllCommodity(CommodityInfo commodity) {
		List<CommodityInfo> commodityList=this.commodityInfoMapper.selectPageAllCommodity(commodity);
		return commodityList;
	}

	@Override
	public List<CommodityInfo> selectLikeAllCommodityInfo(CommodityInfo record) {
		List<CommodityInfo> commodityList=this.commodityInfoMapper.selectPageLikeAllCommodityInfo(record);
		return commodityList;
	}

	@Override
	public List<Category> selectFirstName(Integer type) {
		List<Category> strList=this.commodityInfoMapper.selectFirstName(type);
		return strList;
	}

	@Override
	public List<Category> selectOtherNameByParentId(Integer type) {
		List<Category> strList=this.commodityInfoMapper.selectOtherNameByParentId(type);
		return strList;
	}

	@Override
	public int insertSelective(CommodityInfo record) {
		int ret=this.commodityInfoMapper.insertSelective(record);
		return ret;
	}

	@Override
	public CommodityInfo selectOneByID(Integer id) {
		CommodityInfo commodity=this.commodityInfoMapper.selectByPrimaryKey(id);
		return commodity;
	}

	@Override
	public Category selectCategoryNameById(Integer id) {
		Category category=this.commodityInfoMapper.selectCategoryNameById(id);
		return category;
	}

	@Override
	public int updateByPrimaryKeySelective(CommodityInfo record) {
		int ret=this.commodityInfoMapper.updateByPrimaryKeySelective(record);
		return ret;
	}
	
	
	
}
