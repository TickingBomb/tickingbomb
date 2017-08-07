package com.chinasofti.lexian.manager.user.vo;

import java.util.Date;

import com.chinasofti.lexian.bean.PageBean;

public class User extends PageBean{
    private String id;

    private String phone;

    private String username;

    private String sex;

    private String mail;

    private String portrait;

    private String passwd;

    private Date lastlogintime;

    private Integer status;
    
    private String statusInfo;
    
    private String checkStatus;
    
    private String selectType;
    
    public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public String getStatusInfo() {
		this.setStatusInfo();
		return statusInfo;
	}

	public void setStatusInfo() {
		if(this.status==0)
			this.statusInfo = "停用";
		else if(this.status==1)
			this.statusInfo = "启用";
	}

	public String getCheckStatus() {
		this.setCheckStatus();
		return checkStatus;
	}

	public void setCheckStatus() {
		if(this.status==1)
			this.checkStatus = "停用";
		else if(this.status==0)
			this.checkStatus = "启用";
	}

}