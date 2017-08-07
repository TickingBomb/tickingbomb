package com.chinasofti.lexian.manager.privilege.vo;

import java.util.Date;

public class Browse {
    private Integer id;

    private String commodityNo;

    private String userId;

    private Date browsetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommodityNo() {
        return commodityNo;
    }

    public void setCommodityNo(String commodityNo) {
        this.commodityNo = commodityNo == null ? null : commodityNo.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getBrowsetime() {
        return browsetime;
    }

    public void setBrowsetime(Date browsetime) {
        this.browsetime = browsetime;
    }
}