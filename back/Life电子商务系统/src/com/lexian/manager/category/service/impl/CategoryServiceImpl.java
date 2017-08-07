package com.chinasofti.lexian.manager.category.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.lexian.manager.category.dao.CategoryMapper;
import com.chinasofti.lexian.manager.category.service.CategoryService;
import com.chinasofti.lexian.manager.category.vo.Category;
import com.chinasofti.lexian.manager.user.vo.User;


@Service
public class CategoryServiceImpl implements CategoryService{


	private CategoryMapper categoryMapper;
	
	@Autowired
	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}

	
	@Override
	public List<Category> selectAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> selectPageCategoryByType1(Category category) {
		return categoryMapper.selectPageCategoryByType1(category);
	}

	@Override
	public List<Category> selectPageCategoryByType2(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.selectPageCategoryByType2(category);
	}

	@Override
	public List<Category> selectPageCategoryByType3(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.selectPageCategoryByType3(category);
	}

	@Override
	public int updateByCategoryList(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByCategoryList1(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectByCategoryNameLike(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return 	categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateCategoryNameLike(Category record) {
		// TODO Auto-generated method stub
		return categoryMapper.updateCategoryNameLike(record);
	}


	@Override
	public Category selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByPrimaryKey(id) ;
	}


	@Override
	public int insert(Category record) {
		// TODO Auto-generated method stub
		return categoryMapper.insert(record);
	}


	@Override
	public List<Category> selectByName(String name) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByName(name);
	}


	@Override
	public List<Category> selectPageLikeByName1(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.selectPageCategoryByType1(category);
	}


	@Override
	public List<Category> selectPageLikeByName2(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.selectPageCategoryByType2(category);
	}


	@Override
	public List<Category> selectPageLikeByName3(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.selectPageCategoryByType3(category);
	}


	@Override
	public List<Category> selectCategoryByType1() {
		// TODO Auto-generated method stub
		return categoryMapper.selectCategoryByType1();
	}


	@Override
	public List<Category> selectByType(Integer type) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByType(type);
	}

	@Override
	public List<Category> selectCategoryByType(Integer type) {
		// TODO Auto-generated method stub
		return categoryMapper.selectCategoryByType(type);
	}


}
