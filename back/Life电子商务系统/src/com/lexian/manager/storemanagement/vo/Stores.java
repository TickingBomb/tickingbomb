package com.chinasofti.lexian.manager.storemanagement.vo;

public class Stores {
	private Citys citys; 
	private int id;
	private String store_no;
	private int province_id;
	private int citys_id;
	private int county_id;
	private String storename;
	private String storeaddress;
	private double maxlongitude;
	private double maxlatitude;
	private double minlongitude;
	private double minlatitude;
	private double longitude;
	private double latitude;
	private	String introduce;
	private String starttime;
	private String closetime;
	private int status;
	public int getId() {
		return id;
	}
	public Citys getCitys() {
		return citys;
	}
	public void setCitys(Citys citys) {
		this.citys = citys;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStore_no() {
		return store_no;
	}
	public void setStore_no(String store_no) {
		this.store_no = store_no;
	}
	public int getProvince_id() {
		return province_id;
	}
	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}
	public int getCitys_id() {
		return citys_id;
	}
	public void setCitys_id(int citys_id) {
		this.citys_id = citys_id;
	}
	public int getCounty_id() {
		return county_id;
	}
	public void setCounty_id(int county_id) {
		this.county_id = county_id;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getStoreaddress() {
		return storeaddress;
	}
	public void setStoreaddress(String storeaddress) {
		this.storeaddress = storeaddress;
	}
	public double getMaxlongitude() {
		return maxlongitude;
	}
	public void setMaxlongitude(double maxlongitude) {
		this.maxlongitude = maxlongitude;
	}
	public double getMaxlatitude() {
		return maxlatitude;
	}
	public void setMaxlatitude(double maxlatitude) {
		this.maxlatitude = maxlatitude;
	}
	public double getMinlongitude() {
		return minlongitude;
	}
	public void setMinlongitude(double minlongitude) {
		this.minlongitude = minlongitude;
	}
	public double getMinlatitude() {
		return minlatitude;
	}
	public void setMinlatitude(double minlatitude) {
		this.minlatitude = minlatitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getClosetime() {
		return closetime;
	}
	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
