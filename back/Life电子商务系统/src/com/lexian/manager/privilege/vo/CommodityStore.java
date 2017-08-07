package com.chinasofti.lexian.manager.privilege.vo;

import java.math.BigDecimal;

public class CommodityStore {
    private Integer id;

    private String storeNo;

    private String commodityNo;

    private BigDecimal commodityPrice;

    private BigDecimal realPrice;

    private Integer commodityAmont;

    private Integer commodityLockamont;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo == null ? null : storeNo.trim();
    }

    public String getCommodityNo() {
        return commodityNo;
    }

    public void setCommodityNo(String commodityNo) {
        this.commodityNo = commodityNo == null ? null : commodityNo.trim();
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    public Integer getCommodityAmont() {
        return commodityAmont;
    }

    public void setCommodityAmont(Integer commodityAmont) {
        this.commodityAmont = commodityAmont;
    }

    public Integer getCommodityLockamont() {
        return commodityLockamont;
    }

    public void setCommodityLockamont(Integer commodityLockamont) {
        this.commodityLockamont = commodityLockamont;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}