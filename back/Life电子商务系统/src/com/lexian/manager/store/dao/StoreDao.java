package com.chinasofti.lexian.manager.store.dao;

import java.util.List;

import com.chinasofti.lexian.manager.privilege.vo.Commodity;
import com.chinasofti.lexian.manager.privilege.vo.Commodity_store;
import com.chinasofti.lexian.manager.store.vo.Store;

public interface StoreDao {
	
	List<Store> searchPagestoreCommoditiesList(Store store);

	List<Store> storePageSearch(Store store);

	Store storePageMessage(Store store);

	List<Commodity_store> selectPageSearch(Commodity_store commodity_store);

	int updateupdown(Commodity_store user);

	List<Commodity_store> search();

	int updateByPriceChange(Commodity_store commodity_store);

	int updateByAmontChange(Commodity_store commodity_store);
	
	public List<Commodity> searchCommodityList();

	List<Commodity> searchCommodity(Commodity commodity);
}
