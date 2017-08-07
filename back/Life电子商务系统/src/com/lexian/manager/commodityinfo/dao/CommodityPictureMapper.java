package com.chinasofti.lexian.manager.commodityinfo.dao;

import java.util.List;

import com.chinasofti.lexian.manager.commodityinfo.vo.CommodityPicture;

public interface CommodityPictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommodityPicture record);

    int insertSelective(CommodityPicture record);

    CommodityPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommodityPicture record);

    int updateByPrimaryKey(CommodityPicture record);
    
    List<CommodityPicture> selectByCommodityNo(String id);
}