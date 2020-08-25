package com.hltx.mp.beans;

import java.io.Serializable;

/**
 * User: ycj
 * Date: 2020/8/19
 * Time: 14:54
 * Description:
 */
public class Admin implements Serializable {

    private Integer id;

    private String logname;

    private String pwd;

    private Integer status;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", logname='" + logname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
