package com.chinasofti.lexian.manager.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.lexian.manager.order.dao.OrdersMapper;
import com.chinasofti.lexian.manager.order.service.OrderService;
import com.chinasofti.lexian.manager.order.vo.Orders;

@Service
public class OrderServiceImpl implements OrderService {

	private OrdersMapper ordersMapper;
	
	@Autowired
	public void setOrdersMapper(OrdersMapper ordersMapper) {
		this.ordersMapper = ordersMapper;
	}
	
	@Override
	public List<Orders> selectOrders(Orders orders) {
//		Orders orders=new Orders();
		return ordersMapper.selectPageOrders(orders);
	}

	@Override
	public List<Orders> selectOrdersByStates(Orders orders) {
		return ordersMapper.selectPageOrdersByStates(orders);
	}
	
	@Override
	public Orders selectOrderParticulars(Integer id) {
		return ordersMapper.selectOrderParticulars(id);
	}

	@Override
	public int deliverGoods(Integer id) {
		return ordersMapper.deliverGoods(id);
	}

	@Override
	public List<Orders> searchOrders(Orders orders) {
		return ordersMapper.searchPageOrders(orders);
	}

}
