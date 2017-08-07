package com.chinasofti.lexian.manager.storemanagement.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.chinasofti.lexian.manager.storemanagement.dao.StoreManagementDao;
import com.chinasofti.lexian.manager.storemanagement.service.StoreManageService;
import com.chinasofti.lexian.manager.storemanagement.vo.Citys;
import com.chinasofti.lexian.manager.storemanagement.vo.Page;
import com.chinasofti.lexian.manager.storemanagement.vo.Stores;

@Service
public class StoreManageServiceImpl implements StoreManageService {

	private StoreManagementDao sm;

	@Autowired
	public void setPrivilegeDao(StoreManagementDao sm) {
		this.sm = sm;
	}

	// 添加门店信息
	public int addStore(Stores stores) {
		return sm.insertStore(stores);
	}

	// 操作店门的状态Status
	public int updatestatus(Stores stores) {
		return sm.updateStatus(stores);

	}

	// 修改门店信息——查询
	public List<Stores> storesmodify(Stores stores) {
		return sm.modifyinfo(stores);

	}
	@Override
	public List<Citys>  updateCitys(int id) {
		// TODO Auto-generated method stub
		return sm.updateCitys(id);
	}
	public int updateStore(Stores stores) {
		return sm.updateStore(stores);
	}

	// 城市信息查询（添加）
	public List<Citys> selectcitys() {
		return sm.findcity();

	}

	// 城市信息查询（修改）
	public List<Citys> selectstorecitys() {
		return sm.findstorecity();

	}

	// 三级联动
	public List<Citys> searchCitys(Citys citys) {
		return sm.searchCitys(citys);
	}

	public List<Citys> searchCitysByParentId(Citys citys) {
		return sm.searchCitysByParentId(citys);
	}

	//模糊 分页
		public void showProductsByPage(HttpServletRequest request, Model model, Stores stores) {
			String pageNow = request.getParameter("pageNow");
			Page page = null;

			// 获得总条数count（*）的返回值为Integer型
			int totalCount = (Integer) sm.getUserCountLike(stores);
			List<Stores> listUser;

			if (pageNow != null) {
				// 实例化page传入totalCount——pageNow
				page = new Page(totalCount, Integer.parseInt(pageNow));
				page.setStore_no(stores.getStore_no());
				page.setStorename(stores.getStorename());
				System.out.println(page.getStorename()+"----storename");
				listUser = this.sm.selectUserByP(page);
			} else {
				page = new Page(totalCount, 1);
				page.setStore_no(stores.getStore_no());
				page.setStorename(stores.getStorename());
				System.out.println(page.getStorename()+"----storename");
				listUser = this.sm.selectUserByP(page);
			}

			model.addAttribute("page", page);
			model.addAttribute("storeslist", listUser);
			model.addAttribute("stores",stores);
		}
		//查询所有分页
		public void showAllByPage(HttpServletRequest request, Model model,Stores stores){
			String pageNow = request.getParameter("pageNow"); 
			Page page = null;  
			//获得总条数count（*）的返回值为Integer型
			int totalCount = (Integer)sm.getUserCount();
			System.out.println(totalCount+"总条数");
			List<Stores> listUser;
			if (pageNow != null) {  
				//实例化page传入totalCount——pageNow
				page = new Page(totalCount, Integer.parseInt(pageNow)); 
				listUser = this.sm.selectAllByP(page); 
			} else {  
				page = new Page(totalCount, 1);
				listUser = this.sm.selectAllByP(page);
			}  
			model.addAttribute("page", page);
			model.addAttribute("storeslist", listUser);
		}

	// 所有分页跳转
	public void showSkipPage(HttpServletRequest request, Model model,Stores stores) {
		String skipPage = request.getParameter("skipPage");
		String totalPage=request.getParameter("totalPage");
		System.out.println(totalPage+"总页数");
		int intPage=Integer.parseInt(skipPage);
		System.out.println(skipPage);
		Page page = null;
		// 获得总条数count（*）的返回值为Integer型
		int totalCount = (Integer) sm.getUserCount();
		System.out.println(totalCount+"总条数");
		List<Stores> listUser = null;
		if (intPage>0&intPage<Integer.parseInt(totalPage)) {
		
				// 实例化page传入totalCount——pageNow
				System.out.println("pagenow正常");
				page = new Page(totalCount, Integer.parseInt(skipPage));
				listUser = this.sm.selectUserByP(page);
			
		} else {
			System.out.println("pagenow--1");
			page = new Page(totalCount, 1);
			listUser = this.sm.selectUserByP(page);
		}
		model.addAttribute("page", page);
		model.addAttribute("storeslist", listUser);
	}
	
}
