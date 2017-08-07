package com.chinasofti.lexian.manager.order.vo;

import java.util.Date;
import java.util.List;

import com.chinasofti.lexian.bean.PageBean;
import com.chinasofti.lexian.manager.commodityinfo.vo.CommodityInfo;
import com.chinasofti.lexian.manager.user.vo.User;

public class Orders extends PageBean {
    private Integer id;

    private String orderNo;

    private String userId;

    private String storeNo;

    private Double totalamount;

    private String paymenttype;

    private String paymentsubtype;

    private String deliverytype;

    private String states;

    private Date createtime;
    
    private Store store;
    
    private List<CommodityInfo> commodity;
    
    private User user;
    
    private String starttime;
    
    private String endtime;
    
    private String condition;
    
    private String orderInfo;
    
    public void setInfoHashMap(){
    	
    	this.setInfoHashMap("states", states);
    	this.setInfoHashMap("createtime>=", starttime);
    	this.setInfoHashMap("createtime<=", endtime);
    	this.setInfoHashMap("orderNo", orderInfo);
    	this.setInfoHashMap("storename", orderInfo);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype == null ? null : paymenttype.trim();
    }

    public String getPaymentsubtype() {
        return paymentsubtype;
    }

    public void setPaymentsubtype(String paymentsubtype) {
        this.paymentsubtype = paymentsubtype == null ? null : paymentsubtype.trim();
    }

    public String getDeliverytype() {
        return deliverytype;
    }

    public void setDeliverytype(String deliverytype) {
        this.deliverytype = deliverytype == null ? null : deliverytype.trim();
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<CommodityInfo> getCommodity() {
		return commodity;
	}

	public void setCommodity(List<CommodityInfo> commodity) {
		this.commodity = commodity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}
}