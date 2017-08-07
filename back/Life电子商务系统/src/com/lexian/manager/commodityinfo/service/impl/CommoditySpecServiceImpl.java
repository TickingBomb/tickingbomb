package com.chinasofti.lexian.manager.commodityinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.lexian.manager.commodityinfo.dao.CommoditySpecMapper;
import com.chinasofti.lexian.manager.commodityinfo.service.CommoditySpecService;
import com.chinasofti.lexian.manager.commodityinfo.vo.CommoditySpec;


@Service
public class CommoditySpecServiceImpl implements CommoditySpecService{
	
	private CommoditySpecMapper commoditySpecMapper;
	
	@Autowired
	public void setCommoditySpecMapper(CommoditySpecMapper commoditySpecMapper) {
		this.commoditySpecMapper = commoditySpecMapper;
	}

	@Override
	public int insertSelective(CommoditySpec record) {
		int ret=this.commoditySpecMapper.insertSelective(record);
		return ret;
	}

	@Override
	public List<CommoditySpec> selectCommoditySpecByCommodityNo(String commodityNo) {
		List<CommoditySpec> specList=this.commoditySpecMapper.selectCommoditySpecByCommodityNo(commodityNo);
		return specList;
	}

	@Override
	public int deleteByPrimaryKey(Integer specid) {
		int ret=this.commoditySpecMapper.deleteByPrimaryKey(specid);
		return ret;
	}

	
}
