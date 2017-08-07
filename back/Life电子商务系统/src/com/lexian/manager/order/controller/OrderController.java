package com.chinasofti.lexian.manager.order.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.lexian.manager.order.service.OrderService;
import com.chinasofti.lexian.manager.order.vo.Orders;

@Controller
@RequestMapping("/login")
public class OrderController {

	private OrderService orderService;
	
	@Autowired
	public void setPrivilegeService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//订单列表、已付款订单、未付款订单、已发货订单、已完成订单
	@RequestMapping("/ordersList.do")
	public String ordersList(@ModelAttribute("pageBean") Orders orders, String msg, Model model) throws UnsupportedEncodingException {

		msg = new String(msg.getBytes("iso-8859-1"), "utf-8");
		model.addAttribute("msg",msg);
		
		//该方法将传过来的数据写入父类pageBean的selectInfo集合中
		//orders.setInfoHashMap();
		
		orders.setSelectInfo(orders.getStates());
		List<Orders> ordersList = orderService.selectOrders(orders);
		model.addAttribute("ordersList", ordersList);
		return "ordersList";
	}
	
	//订单详情
	@RequestMapping("/orderParticulars.do")
	public String orderParticulars(Integer id, Model model) {
		Orders order = orderService.selectOrderParticulars(id);
		model.addAttribute("order", order);
		return "orderParticulars";
	}
	
	//发货
	@RequestMapping("/deliverGoods.do")
	public String deliverGoods(@ModelAttribute("pageBean") Orders orders,@ModelAttribute("msg") String msg, Model model) throws UnsupportedEncodingException {
		orderService.deliverGoods(orders.getId());
		return ordersList(orders,msg,model);
	}

	//搜索订单
	@RequestMapping("/searchOrders.do")
	public String searchOrder(Orders orders,@ModelAttribute("msg") String msg,
			Model model) throws UnsupportedEncodingException {
		orders.setOrderInfo("请输入搜索内容".equals(orders.getOrderInfo())?"":orders.getOrderInfo());
		//判断sql文有几个搜索条件
		int count = 0;
		String selectInfo = "";
		if (!"".equals(orders.getStarttime())) {
			count++;
			selectInfo = orders.getStarttime();
		}
		if (!"".equals(orders.getEndtime())) {
			count++;
			selectInfo = orders.getEndtime();
		}
		if (!"".equals(orders.getOrderInfo())) {
			count++;
			selectInfo = orders.getOrderInfo();
		}
		if (!"0".equals(orders.getStates()) && !"".equals(orders.getStates())) {
			count++;
			selectInfo = orders.getStates();
		}
		//只有一个搜索条件将该条件赋给selectInfo
		if (count == 1) {
			orders.setSelectInfo(selectInfo);
		}else if(count > 1){
			//有多个搜索条件
			//该方法将传过来的数据写入父类pageBean的selectInfo集合中
			orders.setInfoHashMap();
		}
		
		
	 	List<Orders> ordersList = orderService.searchOrders(orders);
	 	model.addAttribute("pageBean", orders);
	 	model.addAttribute("ordersList", ordersList);
		return "ordersList";
	}

}
