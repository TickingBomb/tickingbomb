package com.chinasofti.lexian.manager.store.service;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.chinasofti.lexian.manager.privilege.vo.Commodity;
import com.chinasofti.lexian.manager.privilege.vo.Commodity_store;
import com.chinasofti.lexian.manager.store.vo.Store;

public interface StoreService {

	// 查询上下架
	List<Store> searchPagestoreCommoditiesList(Store store1);

	// 搜索框查询上下架
	public List<Store> storePageSearch(Store store);

	// 中软国际
	public Store storePageMessage(Store store);

	// 更改上下架
	public int updateupdown(@ModelAttribute("model") Commodity_store user);

	// 查看商品信息
	public List<Commodity_store> search();

	// 改变价格
	public int updateByPriceChange(Commodity_store commodity_store);

	// 改变库存
	public int updateByAmontChange(Commodity_store commodity_store);
	
	public List<Commodity> searchCommodityList();

	public List<Commodity> searchCommodity(Commodity commodity) ;
		
	public List<Commodity_store> selectPageSearch(Commodity_store commodity_store);
	
}
