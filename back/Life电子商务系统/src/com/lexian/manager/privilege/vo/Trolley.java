package com.chinasofti.lexian.manager.privilege.vo;

import java.util.Date;

public class Trolley {
    private Integer id;

    private String userId;

    private String storeNo;

    private String commodityNo;

    private Integer amont;

    private Double listprice;

    private Double totalprice;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public Integer getAmont() {
        return amont;
    }

    public void setAmont(Integer amont) {
        this.amont = amont;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}