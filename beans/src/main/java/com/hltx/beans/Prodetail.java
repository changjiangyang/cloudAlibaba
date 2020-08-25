package com.hltx.beans;

import java.io.Serializable;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:37
 * Description:
 */
public class Prodetail implements Serializable {

    private String id ;
    /** 商品id;商品编号 */
    private String proid ;
    /** 商品名;商品名 */
    private String proname ;
    /** 详情;商品参数信息写入HTML文件，然后让前端引用 */
    private String details ;

    /**  */
    public String getId(){
        return this.id;
    }
    /**  */
    public void setId(String id){
        this.id = id;
    }
    /** 商品id;商品编号 */
    public String getProid(){
        return this.proid;
    }
    /** 商品id;商品编号 */
    public void setProid(String proid){
        this.proid = proid;
    }
    /** 商品名;商品名 */
    public String getProname(){
        return this.proname;
    }
    /** 商品名;商品名 */
    public void setProname(String proname){
        this.proname = proname;
    }
    /** 详情;商品参数信息写入HTML文件，然后让前端引用 */
    public String getDetails(){
        return this.details;
    }
    /** 详情;商品参数信息写入HTML文件，然后让前端引用 */
    public void setDetails(String details){
        this.details = details;
    }
}
