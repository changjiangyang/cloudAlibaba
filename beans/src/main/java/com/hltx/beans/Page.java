package com.hltx.beans;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * User: ycj
 * Date: 2020/8/11
 * Time: 17:51
 * Description:
 */
public class Page implements Serializable {

    private int id;

    private String createuser;

    private Timestamp createTime;

    private String cintext;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCintext() {
        return cintext;
    }

    public void setCintext(String cintext) {
        this.cintext = cintext;
    }
}
