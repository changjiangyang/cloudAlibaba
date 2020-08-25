package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:41
 * Description:
 */
public class ComStaff implements Serializable {

    private Integer id ;
    /** 员工姓名 */
    private String name ;
    /** 合同编号 */
    private Integer contract ;
    /** 电话 */
    private String phone ;
    /** 住址 */
    private String address ;
    /** 入职时间 */
    private Date entrytime ;
    /** 性别0女1男 */
    private String sex ;
    /** 年龄 */
    private Integer age ;
    /** 邮箱地址 */
    private String email ;
    /** 工号 */
    private String jobnumber ;
    /** 部门id */
    private Integer departmentid ;
    /** 企业id */
    private Integer companyid ;
    /** 岗位id */
    private Integer stationid ;

    /**  */
    public Integer getId(){
        return this.id;
    }
    /**  */
    public void setId(Integer id){
        this.id = id;
    }
    /** 员工姓名 */
    public String getName(){
        return this.name;
    }
    /** 员工姓名 */
    public void setName(String name){
        this.name = name;
    }
    /** 合同编号 */
    public Integer getContract(){
        return this.contract;
    }
    /** 合同编号 */
    public void setContract(Integer contract){
        this.contract = contract;
    }
    /** 电话 */
    public String getPhone(){
        return this.phone;
    }
    /** 电话 */
    public void setPhone(String phone){
        this.phone = phone;
    }
    /** 住址 */
    public String getAddress(){
        return this.address;
    }
    /** 住址 */
    public void setAddress(String address){
        this.address = address;
    }
    /** 入职时间 */
    public Date getEntrytime(){
        return this.entrytime;
    }
    /** 入职时间 */
    public void setEntrytime(Date entrytime){
        this.entrytime = entrytime;
    }
    /** 性别0女1男 */
    public String getSex(){
        return this.sex;
    }
    /** 性别0女1男 */
    public void setSex(String sex){
        this.sex = sex;
    }
    /** 年龄 */
    public Integer getAge(){
        return this.age;
    }
    /** 年龄 */
    public void setAge(Integer age){
        this.age = age;
    }
    /** 邮箱地址 */
    public String getEmail(){
        return this.email;
    }
    /** 邮箱地址 */
    public void setEmail(String email){
        this.email = email;
    }
    /** 工号 */
    public String getJobnumber(){
        return this.jobnumber;
    }
    /** 工号 */
    public void setJobnumber(String jobnumber){
        this.jobnumber = jobnumber;
    }
    /** 部门id */
    public Integer getDepartmentid(){
        return this.departmentid;
    }
    /** 部门id */
    public void setDepartmentid(Integer departmentid){
        this.departmentid = departmentid;
    }
    /** 企业id */
    public Integer getCompanyid(){
        return this.companyid;
    }
    /** 企业id */
    public void setCompanyid(Integer companyid){
        this.companyid = companyid;
    }
    /** 岗位id */
    public Integer getStationid(){
        return this.stationid;
    }
    /** 岗位id */
    public void setStationid(Integer stationid){
        this.stationid = stationid;
    }
}
