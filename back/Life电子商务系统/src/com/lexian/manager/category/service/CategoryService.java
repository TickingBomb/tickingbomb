package com.chinasofti.lexian.manager.category.service;

import java.util.List;

import com.chinasofti.lexian.manager.category.vo.Category;
import com.chinasofti.lexian.manager.user.vo.User;



public interface CategoryService {
	
	public List<Category> selectAllCategory();
	
	public List<Category> selectPageCategoryByType1(Category category);
    
	public List<Category> selectPageCategoryByType2(Category category);
    
	public List<Category> selectPageCategoryByType3(Category category);
	
	public int updateByCategoryList(String id);
	
	public int updateByCategoryList1(String id);
	
	public List<User> selectByCategoryNameLike(String str);
	
	public int deleteByPrimaryKey(Integer id);
	
	public int updateCategoryNameLike(Category record);
	
	public  Category selectByPrimaryKey(Integer id);
	
	public  int insert(Category record);
	
	public List<Category> selectByName(String name);
	
	public List<Category> selectByType(Integer type);
	
	public List<Category> selectPageLikeByName1(Category category);
	    
	public List<Category> selectPageLikeByName2(Category category);
	    
	public List<Category> selectPageLikeByName3(Category category);
	
	public List<Category> selectCategoryByType1();
	
	public List<Category> selectCategoryByType(Integer type);
	
}
