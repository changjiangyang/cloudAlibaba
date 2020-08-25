package com.hltx.beans;

import java.io.Serializable;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:32
 * Description:
 */
public class UAddress implements Serializable {

    private String id ;

    /**  */
    public String getId(){
        return this.id;
    }
    /**  */
    public void setId(String id){
        this.id = id;
    }
}
