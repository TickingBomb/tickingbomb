package com.chinasofti.lexian.manager.privilege.vo;

public class Menu {
    private Integer id;

    private String url;

    private String name;

    private String backurl;

    private Integer parentid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBackurl() {
        return backurl;
    }

    public void setBackurl(String backurl) {
        this.backurl = backurl == null ? null : backurl.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}