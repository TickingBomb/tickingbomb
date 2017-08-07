package com.chinasofti.lexian.manager.privilege.vo;

import java.util.Date;

public class Store {
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

    private Date starttime;

    private Date closetime;

    private Integer status;

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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getClosetime() {
        return closetime;
    }

    public void setClosetime(Date closetime) {
        this.closetime = closetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}