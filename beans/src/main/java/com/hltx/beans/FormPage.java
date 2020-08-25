package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

public class FormPage implements Serializable {

    private String id;

    private Integer companyid;

    private Integer parid;

    private Date createtime;

    private String createuser;

    private String columns;

    private String name;

    private String title;

    private Date updateTime;

    private Integer status;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getParid() {
        return parid;
    }

    public void setParid(Integer parid) {
        this.parid = parid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "FormPage{" +
                "id='" + id + '\'' +
                ", companyid=" + companyid +
                ", parid=" + parid +
                ", createtime=" + createtime +
                ", createuser='" + createuser + '\'' +
                ", columns='" + columns + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}
