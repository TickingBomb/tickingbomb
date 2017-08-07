package com.chinasofti.lexian.manager.storemanagement.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.chinasofti.lexian.manager.storemanagement.vo.Citys;
import com.chinasofti.lexian.manager.storemanagement.vo.Stores;

public interface StoreManageService {

	// 添加门店信息
	public int addStore(Stores stores);

	// 操作店门的状态Status
	public int updatestatus(Stores stores);

	// 修改门店信息——查询
	public List<Stores> storesmodify(Stores stores);
	
	public List<Citys>  updateCitys(int id);
	public int updateStore(Stores stores);

	// 城市信息查询（添加）
	public List<Citys> selectcitys();

	// 城市信息查询（修改）
	public List<Citys> selectstorecitys();

	// 三级联动
	public List<Citys> searchCitys(Citys citys);

	
	public List<Citys> searchCitysByParentId(Citys citys);

	// 分页
	public void showProductsByPage(HttpServletRequest request, Model model, Stores stores);
	public void showAllByPage(HttpServletRequest request, Model model,Stores stores);
	// 分页跳转
	public void showSkipPage(HttpServletRequest request, Model model,Stores stores);

}
