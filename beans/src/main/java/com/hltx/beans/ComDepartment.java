package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:40
 * Description:
 */
public class ComDepartment implements Serializable {

    private Integer id ;
    /** 部门名 */
    private String name ;
    /** 部门创建时间 */
    private Date createtime ;
    /** 添加时间 */
    private Date addtime ;
    /** 部门负责人编号 */
    private String adminid ;
    /** 部门负责人姓名 */
    private String adminname ;
    /** 部门简介 */
    private String explains ;

    /**  */
    public Integer getId(){
        return this.id;
    }
    /**  */
    public void setId(Integer id){
        this.id = id;
    }
    /** 部门名 */
    public String getName(){
        return this.name;
    }
    /** 部门名 */
    public void setName(String name){
        this.name = name;
    }
    /** 部门创建时间 */
    public Date getCreatetime(){
        return this.createtime;
    }
    /** 部门创建时间 */
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }
    /** 添加时间 */
    public Date getAddtime(){
        return this.addtime;
    }
    /** 添加时间 */
    public void setAddtime(Date addtime){
        this.addtime = addtime;
    }
    /** 部门负责人编号 */
    public String getAdminid(){
        return this.adminid;
    }
    /** 部门负责人编号 */
    public void setAdminid(String adminid){
        this.adminid = adminid;
    }
    /** 部门负责人姓名 */
    public String getAdminname(){
        return this.adminname;
    }
    /** 部门负责人姓名 */
    public void setAdminname(String adminname){
        this.adminname = adminname;
    }
    /** 部门简介 */
    public String getExplains(){
        return this.explains;
    }
    /** 部门简介 */
    public void setExplains(String explains){
        this.explains = explains;
    }
}
