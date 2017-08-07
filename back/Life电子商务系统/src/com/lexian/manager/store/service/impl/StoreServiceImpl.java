package com.chinasofti.lexian.manager.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.chinasofti.lexian.manager.privilege.vo.Commodity;
import com.chinasofti.lexian.manager.privilege.vo.Commodity_store;
import com.chinasofti.lexian.manager.store.dao.StoreDao;
import com.chinasofti.lexian.manager.store.service.StoreService;
import com.chinasofti.lexian.manager.store.vo.Store;

@Service
public class StoreServiceImpl implements StoreService {

	private StoreDao storeDao;
	
	@Autowired
	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}

	// 查询上下架
	public List<Store> searchPagestoreCommoditiesList(Store store1) {
		List<Store> store = this.storeDao.searchPagestoreCommoditiesList(store1);
		return store;
	}

	// 搜索框查询上下架
	public List<Store> storePageSearch(Store store) {
		List<Store> storeList = this.storeDao.storePageSearch(store);
		return storeList;
	}

	// 中软国际
	public Store storePageMessage(Store store) {
		return this.storeDao.storePageMessage(store);
	}

	// 更改上下架
	public int updateupdown(@ModelAttribute("model") Commodity_store user) {
		int update = this.storeDao.updateupdown(user);
		return update;
	}

	// 查看商品信息
	public List<Commodity_store> search() {
		List<Commodity_store> user = this.storeDao.search();
		return user;
	}

	// 改变价格
	public int updateByPriceChange(Commodity_store commodity_store) {
		return this.storeDao.updateByPriceChange(commodity_store);

	}

	// 改变库存
	public int updateByAmontChange(Commodity_store commodity_store) {
		int update = this.storeDao.updateByAmontChange(commodity_store);
		return update;
	}

	public List<Commodity> searchCommodityList() {
		List<Commodity> user = this.storeDao.searchCommodityList();
		System.out.println("============================");
		return user;
	}

	public List<Commodity> searchCommodity(Commodity commodity) {
		List<Commodity> storeList = this.storeDao.searchCommodity(commodity);
		return storeList;
	}

	public List<Commodity_store> selectPageSearch(Commodity_store commodity_store) {
		List<Commodity_store> comList = this.storeDao.selectPageSearch(commodity_store);
		return comList;
	}
}
