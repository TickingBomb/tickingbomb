package com.chinasofti.lexian.manager.storemanagement.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.lexian.manager.storemanagement.service.StoreManageService;
import com.chinasofti.lexian.manager.storemanagement.vo.Citys;
import com.chinasofti.lexian.manager.storemanagement.vo.Stores;

@Controller
@RequestMapping("/login")
public class SMController {

	private StoreManageService storeManageService;

	@Autowired
	public void setStoreManageService(StoreManageService storeManageService) {
		this.storeManageService = storeManageService;
	}

	// 模糊查询
	@RequestMapping("/searchStore.do")
	public String searchStore(@ModelAttribute("model") Stores stores, Model model, HttpServletRequest request)
			throws Exception {
		String storeChoose = request.getParameter("storeSelect");
		System.out.println(storeChoose+"----storeChoose");
		if ("门店编号".equals(storeChoose)) {
			String store_no = request.getParameter("storeName");
			System.out.println(store_no);
			stores.setStore_no(store_no);
			// 分页方法
			this.storeManageService.showProductsByPage(request, model, stores);
		}
		if ("门店名称".equals(storeChoose)) {
			String name = request.getParameter("storeName");
			stores.setStorename(name);
			// 分页方法
			this.storeManageService.showProductsByPage(request, model, stores);

		}
		return "storesList";
	}

	// 添加 提交按钮跳转
	@RequestMapping("/add.do")
	public String add(Stores stores, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		String storename = request.getParameter("storename");
		String storeaddress = request.getParameter("storeaddress");
		String introduce = request.getParameter("introduce");
		String province_id = request.getParameter("province_id");
		String citys_id = request.getParameter("citys_id");
		String county_id = request.getParameter("county_id");
		String maxlatitude = request.getParameter("maxlatitude");
		String minlatitude = request.getParameter("minlatitude");
		String maxlongitude = request.getParameter("maxlongitude");
		String minlongitude = request.getParameter("minlongitude");
		double maxla=Double.parseDouble(maxlatitude);
		double minla=Double.parseDouble(minlatitude);
		double maxlo=Double.parseDouble(maxlongitude);
		double minlo=Double.parseDouble(minlongitude);
		if (maxla>=360||maxlo>=360||minla<=0||minlo<=0||minla>=360||minlo>=360||maxla<=0||maxlo<=0) {
			return "forward:add.do";
		}
		System.out.println(province_id + "------province_id");
		stores.setStorename(storename);
		stores.setStoreaddress(storeaddress);
		stores.setIntroduce(introduce);
		stores.setProvince_id(Integer.parseInt(province_id));
		stores.setCitys_id(Integer.parseInt(citys_id));
		stores.setCounty_id(Integer.parseInt(county_id));
		int a = this.storeManageService.addStore(stores);
		if (a != -1) {
			this.storeManageService.showAllByPage(request, model, stores);
			return "storesList";
		}
		return "addStore";
	}

	// 添加门店信息 --三级联动
	@RequestMapping("/AddStore.do")
	public String addStore(Citys citys, Model model, Integer clazz) {
		citys.setClazz(clazz);
		List<Citys> cityslist = this.storeManageService.searchCitys(citys);
		model.addAttribute("cityslist", cityslist);
		return "addStore";
	}

	/**
	 * 
	 * Ajax请求得到子类商品信息 post方式，返回类型为json
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findcitysbyparentid.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public List<Citys> findCitysByParentId(Citys citys) {
		System.out.println("citysId--------" + citys.getId());
		List<Citys> cityslist = this.storeManageService.searchCitysByParentId(citys);
		return cityslist;// 在这里配置文件和jackson工具就自动转化了，直接返回对象即可
	}

	// 部门信息操作(启动/禁用)
	@RequestMapping("/store_operate.do")
	public String storeInfo_operate(HttpServletRequest request, Stores stores, Model model) {
		this.storeManageService.updatestatus(stores);
		this.storeManageService.showAllByPage(request, model, stores);
		return "storesList";
	}

	// 部门信息修改——查询
		@RequestMapping("/store_modify.do")
		public String storeInfo_Modify(Stores stores, Citys citys, Model model, String store_no,int province_id,int citys_id,int county_id) {
			System.out.println(province_id+"省id");
			stores.setStore_no(store_no);
			citys.setClazz(1);
			List<Stores> storeslist = this.storeManageService.storesmodify(stores);
//			查默认省市区
			List<Citys>  province=this.storeManageService.updateCitys(province_id);
			System.out.println(province+"----省默认");
			List<Citys> city=this.storeManageService.updateCitys(citys_id);
			List<Citys> county=this.storeManageService.updateCitys(county_id);
			List<Citys> cityslist = this.storeManageService.searchCitys(citys);
			
			model.addAttribute("cityslist", cityslist);
			model.addAttribute("storeslist", storeslist);
			model.addAttribute("province", province);
			model.addAttribute("city", city);
			model.addAttribute("county",county);
			return "modifystore";
		}

	// 修改——更新
	@RequestMapping("/updateStore.do")
	public String store_modify(Stores stores, Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		System.out.println("222");
		String store_no=request.getParameter("store_no");
		String storename = request.getParameter("storename");
		String storeaddress = request.getParameter("storeaddress");
		String introduce = request.getParameter("introduce");
		String maxlatitude = request.getParameter("maxlatitude");
		String minlatitude = request.getParameter("minlatitude");
		String maxlongitude = request.getParameter("maxlongitude");
		String minlongitude = request.getParameter("minlongitude");
		double maxla=Double.parseDouble(maxlatitude);
		double minla=Double.parseDouble(minlatitude);
		double maxlo=Double.parseDouble(maxlongitude);
		double minlo=Double.parseDouble(minlongitude);
		if (maxla>=360||maxlo>=360||minla<=0||minlo<=0||minla>=360||minlo>=360||maxla<=0||maxlo<=0) {
			return "forward:store_modify.do";
		}
		stores.setStore_no(store_no);
		stores.setStorename(storename);
		stores.setStoreaddress(storeaddress);
		stores.setIntroduce(introduce);
		// 获取三级id的value值
		stores.setProvince_id(Integer.parseInt(request.getParameter("province_id")));
		stores.setCitys_id(Integer.parseInt(request.getParameter("citys_id")));
		stores.setCounty_id(Integer.parseInt(request.getParameter("county_id")));
		System.out.println("马上更新");
		this.storeManageService.updateStore(stores);
		System.out.println("更新完毕");
		this.storeManageService.showAllByPage(request, model, stores);
		return "storesList";
	}

	// 模糊分页——用户信息查询
	@RequestMapping("/storesList.do")
	public String userList(HttpServletRequest request, Model model, Stores stores) {
		this.storeManageService.showProductsByPage(request, model, stores);
		return "storesList";
	}

	// 分页跳转
	@RequestMapping("/skipStore.do")
	public String skipStore(HttpServletRequest request, Model model,Stores stores) {
		String skipPage = request.getParameter("skipPage");
		if (skipPage != null & skipPage != "") {
			this.storeManageService.showSkipPage(request, model,stores);
		}else {
			return "forward:storesList.do";
		}
		return "storesList";
	}
	
}
