package com.chinasofti.lexian.manager.commodityinfo.vo;

import java.util.Date;

import com.chinasofti.lexian.bean.PageBean;
import com.chinasofti.lexian.manager.order.vo.Orderitem;


public class CommodityInfo extends PageBean{
    private Integer id;

    private String commodityNo;

    private String name;

    private Integer categoryId;

    private String introduce;

    private String detailed;

    private String pictureurl;

    private Date createtime;

    private Date updatetime;

    private Integer states;
    
    private String selectType;
    
    private Orderitem orderitem;
 
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed == null ? null : detailed.trim();
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl == null ? null : pictureurl.trim();
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

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}

	public Orderitem getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(Orderitem orderitem) {
		this.orderitem = orderitem;
	}
}