package com.chinasofti.lexian.manager.category.vo;

import com.chinasofti.lexian.bean.PageBean;

public class Category extends PageBean{
    private Integer id;

    private String categoryname;

    private Integer type;

    private Integer parentid;
    
    private String parentname;

    public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}