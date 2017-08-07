package com.chinasofti.lexian.manager.privilege.vo;

import java.util.Date;

public class Appmanager {
    private Integer id;

    private String appname;

    private String versionnumber;

    private String appurl;

    private String log;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname == null ? null : appname.trim();
    }

    public String getVersionnumber() {
        return versionnumber;
    }

    public void setVersionnumber(String versionnumber) {
        this.versionnumber = versionnumber == null ? null : versionnumber.trim();
    }

    public String getAppurl() {
        return appurl;
    }

    public void setAppurl(String appurl) {
        this.appurl = appurl == null ? null : appurl.trim();
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log == null ? null : log.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}