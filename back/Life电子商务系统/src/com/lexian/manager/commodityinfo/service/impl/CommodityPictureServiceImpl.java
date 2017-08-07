package com.chinasofti.lexian.manager.commodityinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.lexian.manager.commodityinfo.dao.CommodityPictureMapper;
import com.chinasofti.lexian.manager.commodityinfo.service.CommodityPictureService;
import com.chinasofti.lexian.manager.commodityinfo.vo.CommodityPicture;

@Service
public class CommodityPictureServiceImpl implements CommodityPictureService{

		private CommodityPictureMapper commodityPictureMapper;
		
		@Autowired
		public void setCommodityPictureMapper(CommodityPictureMapper commodityPictureMapper) {
			this.commodityPictureMapper = commodityPictureMapper;
		}
	
		@Override
		public int deleteByPrimaryKey(Integer id) {
			int ret=this.commodityPictureMapper.deleteByPrimaryKey(id);
			return ret;
		}
	
		@Override
		public int insertSelective(CommodityPicture record) {
			int ret=this.commodityPictureMapper.insertSelective(record);
			return ret;
		}

		@Override
		public List<CommodityPicture> selectByCommodityNo(String id) {
			List<CommodityPicture> comList=this.commodityPictureMapper.selectByCommodityNo(id);
			return comList;
		}
	
	}
