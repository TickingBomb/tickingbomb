package com.chinasofti.lexian.manager.statisticsCommodities.vo;

import com.chinasofti.lexian.bean.PageBean;

public class Commodity extends PageBean{
	private String commodity_no;
	private String introduce;
	private int acount;
	private double listprice;
	
	public String getCommodity_no() {
		return commodity_no;
	}
	public void setCommodity_no(String commodity_no) {
		this.commodity_no = commodity_no;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getAcount() {
		return acount;
	}
	public void setAcount(int acount) {
		this.acount = acount;
	}
	public double getListprice() {
		return listprice;
	}
	public void setListprice(double listprice) {
		this.listprice = listprice;
	}
	
}
