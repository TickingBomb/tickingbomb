package com.chinasofti.lexian.manager.privilege.vo;

import com.chinasofti.lexian.bean.PageBean;

public class Commodity_store extends PageBean {

	private String commodity_no;

	private String store_no;

	private int commodity_amont;

	private double commodity_price;

	private double real_price;
	
	private int type;
	
	private String name;
	
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int commodity_lockamont;
	
	
	private Commodity commodity;
	

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public String getCommodity_no() {
		return commodity_no;
	}

	public void setCommodity_no(String commodity_no) {
		this.commodity_no = commodity_no;
	}

	public String getStore_no() {
		return store_no;
	}

	public void setStore_no(String store_no) {
		this.store_no = store_no;
	}

	public int getCommodity_amont() {
		return commodity_amont;
	}

	public void setCommodity_amont(int commodity_amont) {
		this.commodity_amont = commodity_amont;
	}

	public double getCommodity_price() {
		return commodity_price;
	}

	public void setCommodity_price(double commodity_price) {
		this.commodity_price = commodity_price;
	}

	public double getReal_price() {
		return real_price;
	}

	public void setReal_price(double real_price) {
		this.real_price = real_price;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCommodity_lockamont() {
		return commodity_lockamont;
	}

	public void setCommodity_lockamont(int commodity_lockamont) {
		this.commodity_lockamont = commodity_lockamont;
	}
}
