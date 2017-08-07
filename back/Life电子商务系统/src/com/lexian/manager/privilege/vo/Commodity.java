package com.chinasofti.lexian.manager.privilege.vo;

import java.util.Date;

public class Commodity {
	private String name;
	private String commodity_no;
	private int category_id;
	private String introduce;
	private String detailed;
	private String pictureurl;
	private Date createtime;
	private Date updatetime;
	private int states;
	
	public String getCommodity_no() {
		return commodity_no;
	}

	public void setCommodity_no(String commodity_no) {
		this.commodity_no = commodity_no;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getDetailed() {
		return detailed;
	}

	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
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

	public int getStates() {
		return states;
	}

	public void setStates(int states) {
		this.states = states;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
