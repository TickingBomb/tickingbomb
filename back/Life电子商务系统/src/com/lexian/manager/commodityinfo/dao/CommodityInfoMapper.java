package com.chinasofti.lexian.manager.commodityinfo.dao;

import java.util.List;

import com.chinasofti.lexian.manager.category.vo.Category;
import com.chinasofti.lexian.manager.commodityinfo.vo.CommodityInfo;

public interface CommodityInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommodityInfo record);

    int insertSelective(CommodityInfo record);

    CommodityInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommodityInfo record);

    int updateByPrimaryKey(CommodityInfo record);
    
    List<CommodityInfo> selectPageAllCommodity(CommodityInfo record);
    
    List<CommodityInfo> selectPageLikeAllCommodityInfo(CommodityInfo record);
    
    List<Category> selectFirstName(Integer type);
    
    List<Category> selectOtherNameByParentId(Integer parentId);
    
    Category selectCategoryNameById(Integer id);
    
    List<Category> selectCategoryByParentId(Integer type);
    
}