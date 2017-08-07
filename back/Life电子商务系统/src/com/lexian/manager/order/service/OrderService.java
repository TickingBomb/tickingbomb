package com.chinasofti.lexian.manager.order.service;

import java.util.List;

import com.chinasofti.lexian.manager.order.vo.Orders;

public interface OrderService {

	List<Orders> selectOrders(Orders orders);
	
	List<Orders> searchOrders(Orders orders);
	
	List<Orders> selectOrdersByStates(Orders orders);
	
	Orders selectOrderParticulars(Integer id);
	
	int deliverGoods(Integer id);
	
	
}
