package com.chinasofti.lexian.manager.order.dao;

import java.util.List;

import com.chinasofti.lexian.manager.order.vo.Orders;


public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    
    //订单一览
    List<Orders> selectPageOrders(Orders orders);
    
    //不同状态订单
    List<Orders> selectPageOrdersByStates(Orders orders);
    
    //订单详情
    Orders selectOrderParticulars(Integer id);
    
    //发货
    int deliverGoods(Integer id);
    
    //模糊查询订单
    List<Orders> searchPageOrders(Orders orders);
    
}