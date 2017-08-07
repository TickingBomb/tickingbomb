package com.chinasofti.lexian.manager.store.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.lexian.manager.privilege.vo.Commodity_store;
import com.chinasofti.lexian.manager.store.service.StoreService;
import com.chinasofti.lexian.manager.store.vo.Store;

@Controller
@RequestMapping("/login/")
public class StoreController {
	
	private StoreService storeService;
	
	@Autowired
	public void setStoreDao(StoreService storeService) {
		this.storeService = storeService;
	}

		// 查询上下架
		@RequestMapping("storeCommoditiesList.do")
		public String storePageCommoditiesList(@ModelAttribute("pageBean") Store store, Model model) throws Exception {

			System.out.println("-------------" + store.getPageCount());
			List<Store> clzlist = this.storeService.searchPagestoreCommoditiesList(store);
			model.addAttribute("clzlist", clzlist);
			/*
			 * model.addAttribute("selectType", store.getSelectType());
			 * model.addAttribute("selectInfo",store.getSelectInfo());
			 */
			return "storeCommoditiesList";
		}

		// 搜索框查询上下架
		@RequestMapping("storeSearch.do")
		public String storeSearch(@ModelAttribute("pageBean") Store store, Model modelty_store)
				throws UnsupportedEncodingException {
			String name = new String(store.getSelectInfo().getBytes("iso-8859-1"), "utf-8");
			store.setSelectInfo(name);
			List<Store> clzlist = this.storeService.storePageSearch(store);
			modelty_store.addAttribute("clzlist", clzlist);
			return "storeCommoditiesList";
		}

		// 中软国际
		@RequestMapping("/storeMessage.do")
		public String storePageMessage(Commodity_store commodity_store, Model model) throws Exception {
			System.err.println("********storeMessage************");
			List<Commodity_store> clzlist = this.storeService.selectPageSearch(commodity_store);

			// Store clzlist =privilegeServiceImpl.storePageMessage(store);
			// List<Commodity_store> comList= new ArrayList<Commodity_store>();
			// for (Store store2 : clzlist) {
			// comList.add((Commodity_store) store2.getCommodity_store());
			// System.out.println("----info----"+((Commodity_store)store2.getCommodity_store()).getReal_price());
			// }
			model.addAttribute("pageBean", commodity_store);
			model.addAttribute("clzlist", clzlist);
			return "storeMessage";
		}

		// 更改上下架状态
		@RequestMapping("updateupdown.do")
		public String updateupdown(String aa, Integer bb, Model model, Commodity_store store, HttpServletRequest request)
				throws Exception {

			store.setCommodity_no(aa);

			if (bb == 1) {
				store.setType(-1);
			} else {
				store.setType(1);
			}
			this.storeService.updateupdown(store);

			List<Commodity_store> clzlist = this.storeService.selectPageSearch(store);
			System.err.println(clzlist);
			model.addAttribute("pageBean", store);
			model.addAttribute("clzlist", clzlist);
			return "storeMessage";

		}

		// 改变价格
		@RequestMapping("changePrice.do")
		public String changePrice(HttpServletRequest request, String commodity_no, Commodity_store commodity_store,
				Model model) {
			String commodityprice = request.getParameter("commodityprice");
			String realprice = request.getParameter("realprice");
			double dcommodity = Double.valueOf(commodityprice);
			double dreal = Double.valueOf(realprice);
			commodity_store.setCommodity_no(commodity_no);
			commodity_store.setCommodity_price(dcommodity);
			commodity_store.setReal_price(dreal);
			this.storeService.updateByPriceChange(commodity_store);
			return "success";
		}

		// 改变价格
		@RequestMapping("changeThePrice.do")
		public String jump(String commodity_no, Commodity_store commodity_store, Model model) {
			model.addAttribute("commodity_no", commodity_no);
			return "changePrice";

		}

		// 改变库存
		@RequestMapping("changeTheAmont.do")
		public String jump2(String commodity_no, Commodity_store commodity_store, Model model) {
			model.addAttribute("commodity_no", commodity_no);
			return "changeAmont";
		}

		// 改变库存
		@RequestMapping("changeAmont.do")
		public String changeAmont(HttpServletRequest request, String commodity_no, Commodity_store commodity_store,
				Model model) {
			String amont = request.getParameter("amont");
			int theAmont = Integer.valueOf(amont);
			commodity_store.setCommodity_no(commodity_no);
			commodity_store.setCommodity_amont(theAmont);
			this.storeService.updateByAmontChange(commodity_store);
			return "success";
		}

}
