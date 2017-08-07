package com.chinasofti.lexian.manager.category.dao;

import java.util.List;

import com.chinasofti.lexian.manager.category.vo.Category;


public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    
    List<Category> selectAllCategory();
    
    List<Category> selectPageCategoryByType1(Category category);
    
    List<Category> selectPageCategoryByType2(Category category);
    
    List<Category> selectPageCategoryByType3(Category category);
    
    int updateCategoryNameLike(Category record);
    
    List<Category> selectByName(String name);
    
    List<Category> selectByType(Integer type);
    
    List<Category> selectPageLikeByName2(Category category);
    
    List<Category> selectPageLikeByName3(Category category);
    
    List<Category> selectCategoryByType1();
    
    List<Category> selectPageLikeByName1(Category category);
    
    List<Category> selectLikeByName1(Category category);
    
    List<Category> selectCategoryByParenId(Category category);
    
    List<Category> selectCategoryByType(Integer type);
}