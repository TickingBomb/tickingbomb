package com.chinasofti.lexian.manager.order.vo;

public class Orderitem {
    private Integer id;

    private Integer orderId;

    private String commodityNo;

    private Integer amount;

    private Double listprice;

    private Double totalprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCommodityNo() {
        return commodityNo;
    }

    public void setCommodityNo(String commodityNo) {
        this.commodityNo = commodityNo == null ? null : commodityNo.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getListprice() {
        return listprice;
    }

    public void setListprice(Double listprice) {
        this.listprice = listprice;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }
}