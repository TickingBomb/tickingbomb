package com.chinasofti.lexian.manager.role.vo;

import java.util.Date;

import com.chinasofti.lexian.bean.PageBean;

public class Role extends PageBean{
    private Integer id;

    private String name;

    private String description;

    private Date createtime;

    private Date updatetime;
    
    private String selectType;
    
    public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date date) {
		this.createtime = date;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

   
}