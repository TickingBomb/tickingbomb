package com.chinasofti.lexian.manager.statisticsCommodities.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.lexian.manager.statisticsCommodities.service.CommodityService;
import com.chinasofti.lexian.manager.statisticsCommodities.vo.Commodity;

@Controller
@RequestMapping("/login")
public class CommodityController{
	private CommodityService commodityService;	
	
	public CommodityService getCommodityService() {
		return commodityService;
	}
	@Autowired
	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}
	//商品销售概况初始
	@RequestMapping("statisticsCommodities.do")
	public String statisticsCommodities(Commodity commodity,Model model) {
		List<Commodity> comlist = commodityService.selectPageCommodity(commodity);
		List<Commodity> storelist=commodityService.selectStorename();
		model.addAttribute("comlist", comlist);
		model.addAttribute("storelist", storelist);
		model.addAttribute("pageBean", commodity);
		return "statisticsCommodities";
	}
	//销售量排行条件查询
	@RequestMapping("selectByCondition.do")
	public String selectByCondition(Commodity commodity,Model model,HttpServletRequest request) {
		List<Commodity> comlist = commodityService.selectPageCommodityByCondition(commodity);
		List<Commodity> storelist=commodityService.selectStorename();
		model.addAttribute("comlist", comlist);
		model.addAttribute("storelist",storelist);
		model.addAttribute("pageBean", commodity);
		return "statisticsCommodities";
	}
	//浏览量排行条件查询
	@RequestMapping("selectWithPageviewByCondition.do")
	public String selectWithPageviewByCondition(Commodity commodity,Model model) {
		List<Commodity> comlist = commodityService.selectPageCommodityWithPageviewByCondition(commodity);
		List<Commodity> storelist=commodityService.selectStorename();
		model.addAttribute("list", comlist);
		model.addAttribute("storelist",storelist);
		model.addAttribute("pageBean", commodity);
		return "statisticsCommoditiesWithPageview";
	}
	//浏览量排行
	@RequestMapping("statisticsCommoditiesWithPageview.do")
	public String selectCommodity(Commodity commodity,Model model) {
		List<Commodity> comlist = commodityService.selectPageCommodity(commodity);
		List<Commodity> list = commodityService.selectPageCommodityWithCommodity_no(commodity);
		List<Commodity> storelist=commodityService.selectStorename();
		model.addAttribute("comlist", comlist);
		model.addAttribute("list", list);
		model.addAttribute("storelist", storelist);
		model.addAttribute("pageBean", commodity);
		return "statisticsCommoditiesWithPageview";
	}
	
	
	
}
