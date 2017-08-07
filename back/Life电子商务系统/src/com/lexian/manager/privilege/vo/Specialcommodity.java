package com.chinasofti.lexian.manager.privilege.vo;

public class Specialcommodity {
    private Integer id;

    private String commodityno;

    private Integer specialid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommodityno() {
        return commodityno;
    }

    public void setCommodityno(String commodityno) {
        this.commodityno = commodityno == null ? null : commodityno.trim();
    }

    public Integer getSpecialid() {
        return specialid;
    }

    public void setSpecialid(Integer specialid) {
        this.specialid = specialid;
    }
}