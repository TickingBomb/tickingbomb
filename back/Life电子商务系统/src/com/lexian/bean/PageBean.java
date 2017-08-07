package com.chinasofti.lexian.bean;

import java.util.HashMap;

public class PageBean {
	
	private int totalCount;//总的条数
	
	private int pageNo;//当前的页数
	
	private int pageCount;//每页的条数
	
	private int pageLimit;//下一页的条件 等于pageNo*pageCount
	
	private String storename;
	private String starttime;
	private String closetime;
	
	private String selectInfo;
	
	private int state;
	
	private static HashMap<String, String> infoHashMap;//模糊查询配置参数
	
	static{
		infoHashMap = new HashMap<String, String>();
	}
	
	//无参构造方法
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//全参构造方法
	public PageBean(int totalCount, int pageNo, int pageCount) {
		this.totalCount = totalCount;
		this.pageNo = pageNo;
		this.pageCount = pageCount;
	}
	
	//属性的set，get 方法
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
		
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	
	public int getPageLimit() {
		return pageLimit;
	}
	
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	//获取总页数
	public int getTotalPage(){
		if(totalCount % pageCount == 0){
			return totalCount/pageCount;
		}else{
			return totalCount/pageCount+1;
		}
	}
	
	//多写一个判断下一页的方法
	public boolean isNext(){
		return pageNo + 1 < getTotalPage();
	}
	
	//上一页的方法
	public boolean isPrevious(){
		return pageNo > 0;
	}
	
	public String getInfoHashMap(String key) {
		return infoHashMap.get(key);
	}
	
	public void setInfoHashMap(String key, String value) {
		PageBean.infoHashMap.put(key, value);
	}

	public String getSelectInfo() {
		return selectInfo;
	}

	public void setSelectInfo(String selectInfo) {
		this.selectInfo = selectInfo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
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

}

