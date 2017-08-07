package com.chinasofti.lexian.manager.commodityinfo.vo;

public class CommoditySpec {
    private Integer specid;

    private String commodityNo;

    private String specGroup;

    private String specName;

    private Integer states;

    public Integer getSpecid() {
        return specid;
    }

    public void setSpecid(Integer specid) {
        this.specid = specid;
    }

    public String getCommodityNo() {
        return commodityNo;
    }

    public void setCommodityNo(String commodityNo) {
        this.commodityNo = commodityNo == null ? null : commodityNo.trim();
    }

    public String getSpecGroup() {
        return specGroup;
    }

    public void setSpecGroup(String specGroup) {
        this.specGroup = specGroup == null ? null : specGroup.trim();
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }
}