package com.chinasofti.lexian.manager.category.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.lexian.manager.category.service.CategoryService;
import com.chinasofti.lexian.manager.category.vo.Category;

@Controller
@RequestMapping("/login")
public class CategoryController {

	private CategoryService categoryService;

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	// 根据级别查询商品信息
	@RequestMapping("/categoryList.do")
	public String categoryList( Model model) {
		Category category1 = new Category();
		Category category2 = new Category();
		Category category3 = new Category();
		List<Category> categorylist1 = categoryService.selectPageCategoryByType1(category1);
		List<Category> categorylist2 = categoryService.selectPageCategoryByType2(category2);
		List<Category> categorylist3 = categoryService.selectPageCategoryByType3(category3);
		model.addAttribute("categorylist1", categorylist1);
		model.addAttribute("categorylist2", categorylist2);
		model.addAttribute("categorylist3", categorylist3);
		model.addAttribute("pageBean1", category1);
		model.addAttribute("pageBean2", category2);
		model.addAttribute("pageBean3", category3);
		return "categoryList";
	}

	// 跳转添加商品信息jsp
	@RequestMapping("/addCategory.do")
	public String insertCategoryJsp() {
		return "addCategory";
	}

	// 跳转修改商品信息jsp
	@RequestMapping("/toupdate.do")
	public String updateCategoryJsp() {
		return "categoryList";
	}
	//搜索商品
	@RequestMapping("/selectByName.do")
	public String selectByName(@ModelAttribute("name")String name,@ModelAttribute("like")Integer like,HttpServletRequest request) throws UnsupportedEncodingException {
		List<Category> categoryList;
		if (like==1) {
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			categoryList = categoryService.selectByName(name);
		}
		else{
			Integer type = Integer.parseInt(name);
			categoryList = categoryService.selectByType(type);
		}
		request.setAttribute("like", like);	
		request.setAttribute("categorylist", categoryList);
		return "categoryListsearch";
	}
	
	// 跳转添加商品分类管理jsp
	@RequestMapping("/addCategoryName.do")
	public String insertCategoryNameJsp() {
		return "addCategoryName";
	}

	// 跳转到修改category jsp
	@RequestMapping("/jumpToUpdate.do")
	public ModelAndView toUpdate(int id) {
		ModelAndView mav = new ModelAndView();
		Category category = categoryService.selectByPrimaryKey(id);
		mav.setViewName("updateCategory");
		mav.addObject("id", id);
		mav.addObject("categoryname", category.getCategoryname());
		return mav;
	}

	// 删除category
	@RequestMapping("/delete.do")
	public String deleteCategory(int id) {
		int ret = categoryService.deleteByPrimaryKey(id);
		if(ret>0)
			return "redirect:categoryList.do";
		return "error";
	}

	// 修改category
	@RequestMapping("/update.do")
	public String updateCategory(Category category) {
		int ret = categoryService.updateCategoryNameLike(category);
		if(ret>0)
			return "redirect:categoryList.do";
		return "error";
	}
	

	// 添加category
	@RequestMapping("/insertCategory.do")
	public ModelAndView insertCategory(Category category, HttpServletRequest request,Integer selectType,Integer parentId ) throws UnsupportedEncodingException {
	/*	int typeId = Integer.parseInt(request.getParameter("selectType"));*/
		String typeName = request.getParameter("categoryTypeName");
		typeName = new String(typeName.getBytes("ISO-8859-1"), "UTF-8");
	
		category.setType(selectType);
		category.setCategoryname(typeName);
		category.setParentid(parentId);
		categoryService.insert(category);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:categoryList.do");
		return mav;
	}


	//搜索商品
	@RequestMapping("/selectPageLikeByName1.do")
	public String selectByName1(Category category,Model model,HttpServletRequest request) throws UnsupportedEncodingException {
		Category category2 = new Category();
		Category category3 = new Category();
		List<Category> categorylist1 = categoryService.selectPageLikeByName1(category);
		List<Category> categorylist2 = categoryService.selectPageLikeByName2(category2);
		List<Category> categorylist3 = categoryService.selectPageLikeByName3(category3);
		model.addAttribute("categorylist1", categorylist1);
		model.addAttribute("categorylist2", categorylist2);
		model.addAttribute("categorylist3", categorylist3);
		model.addAttribute("pageBean1", category);
		model.addAttribute("pageBean2", category2);
		model.addAttribute("pageBean3", category3);

		return "categoryList";
	}
	@RequestMapping("/selectPageLikeByName2.do")
	public String selectByName2(@ModelAttribute("pageNo")int pageNo,Model model,HttpServletRequest request) throws UnsupportedEncodingException {
		Category category1 = new Category();
		Category category = new Category();
		category.setPageNo(pageNo);
		Category category3 = new Category();
		List<Category> categorylist1 = categoryService.selectPageLikeByName1(category1);
		List<Category> categorylist2 = categoryService.selectPageLikeByName2(category);
		List<Category> categorylist3 = categoryService.selectPageLikeByName3(category3);
		model.addAttribute("categorylist1", categorylist1);
     	model.addAttribute("categorylist2", categorylist2);
		model.addAttribute("categorylist3", categorylist3);
		model.addAttribute("pageBean1", category1);
		model.addAttribute("pageBean2", category);
		model.addAttribute("pageBean3", category3);
		return "categoryList";
	}
	@RequestMapping("/selectPageLikeByName3.do")
	public String selectByName3(@ModelAttribute("pageNo")int pageNo,Model model,HttpServletRequest request) throws UnsupportedEncodingException {
		Category category1 = new Category();
		Category category2 = new Category();
		Category category = new Category();
		category.setPageNo(pageNo);
		List<Category> categorylist1 = categoryService.selectPageLikeByName1(category1);
		List<Category> categorylist2 = categoryService.selectPageLikeByName2(category2);
		List<Category> categorylist3 = categoryService.selectPageLikeByName3(category);
		model.addAttribute("categorylist1", categorylist1);
		model.addAttribute("categorylist2", categorylist2);
		model.addAttribute("categorylist3", categorylist3);
		model.addAttribute("pageBean1", category1);
		model.addAttribute("pageBean2", category2);
		model.addAttribute("pageBean3", category);
		return "categoryList";
	}
	
	/** 				
	 *  				
	 *第一次跳进联动页面获取一级信息	 				
	 * @return 				
	 */  
	@RequestMapping("/selectByTypes.do")				
	public String sanjiliandong(Category category, Model model,Integer type){
		if(type>1){
		List<Category> categoriesList = categoryService.selectCategoryByType(type-1);	
		model.addAttribute("categoriesList", categoriesList);
		model.addAttribute("types",type);
		}
		return "addCategory";			
	}	

}
