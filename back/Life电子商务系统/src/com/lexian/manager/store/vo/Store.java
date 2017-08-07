package com.chinasofti.lexian.manager.store.vo;

import java.util.Date;
import java.util.List;

import com.chinasofti.lexian.bean.PageBean;
import com.chinasofti.lexian.manager.privilege.vo.Commodity_store;

public class Store extends PageBean{
	 private Integer id;

	    private String storeNo;

	    private Integer provinceId;

	    private Integer citysId;

	    private Integer countyId;

	    private String storename;

	    private String storeaddress;

	    private Double maxlongitude;

	    private Double maxlatitude;

	    private Double minlongitude;

	    private Double minlatitude;

	    private Double longitude;

	    private Double latitude;

	    private String introduce;

	    private Date starttimes;

	    private Date closetimes;

	    private Integer status;
	   

	/*	public String getSelectInfo() {
			return selectInfo;
		}
	    
	    public void setSelectInfo(String selectInfo) {
			this.selectInfo = selectInfo;
		}*/

		private List<Commodity_store> commodity_store;

	    public List<Commodity_store> getCommodity_store() {
			return commodity_store;
		}

		public void setCommodity_store(List<Commodity_store> commodity_store) {
			this.commodity_store = commodity_store;
		}

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

	    public Integer getProvinceId() {
	        return provinceId;
	    }

	    public void setProvinceId(Integer provinceId) {
	        this.provinceId = provinceId;
	    }

	    public Integer getCitysId() {
	        return citysId;
	    }

	    public void setCitysId(Integer citysId) {
	        this.citysId = citysId;
	    }

	    public Integer getCountyId() {
	        return countyId;
	    }

	    public void setCountyId(Integer countyId) {
	        this.countyId = countyId;
	    }

	    public String getStorename() {
	        return storename;
	    }

	    public void setStorename(String storename) {
	        this.storename = storename == null ? null : storename.trim();
	    }

	    public String getStoreaddress() {
	        return storeaddress;
	    }

	    public void setStoreaddress(String storeaddress) {
	        this.storeaddress = storeaddress == null ? null : storeaddress.trim();
	    }

	    public Double getMaxlongitude() {
	        return maxlongitude;
	    }

	    public void setMaxlongitude(Double maxlongitude) {
	        this.maxlongitude = maxlongitude;
	    }

	    public Double getMaxlatitude() {
	        return maxlatitude;
	    }

	    public void setMaxlatitude(Double maxlatitude) {
	        this.maxlatitude = maxlatitude;
	    }

	    public Double getMinlongitude() {
	        return minlongitude;
	    }

	    public void setMinlongitude(Double minlongitude) {
	        this.minlongitude = minlongitude;
	    }

	    public Double getMinlatitude() {
	        return minlatitude;
	    }

	    public void setMinlatitude(Double minlatitude) {
	        this.minlatitude = minlatitude;
	    }

	    public Double getLongitude() {
	        return longitude;
	    }

	    public void setLongitude(Double longitude) {
	        this.longitude = longitude;
	    }

	    public Double getLatitude() {
	        return latitude;
	    }

	    public void setLatitude(Double latitude) {
	        this.latitude = latitude;
	    }

	    public String getIntroduce() {
	        return introduce;
	    }

	    public void setIntroduce(String introduce) {
	        this.introduce = introduce == null ? null : introduce.trim();
	    }

	    public Date getStarttimes() {
			return starttimes;
		}

		public void setStarttimes(Date starttimes) {
			this.starttimes = starttimes;
		}

		public Date getClosetimes() {
			return closetimes;
		}

		public void setClosetimes(Date closetimes) {
			this.closetimes = closetimes;
		}

		public Integer getStatus() {
	        return status;
	    }

	    public void setStatus(Integer status) {
	        this.status = status;
	    }

}
