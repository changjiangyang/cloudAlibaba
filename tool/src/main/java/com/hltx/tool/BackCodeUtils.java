package com.hltx.tool;

import java.util.HashMap;
import java.util.Map;

/**
 * User: ycj
 * Date: 2020/8/3
 * Time: 16:41
 * Description:
 */
public class BackCodeUtils {

    public static String SUCCESSCODE= "10000";
    public static String SUCCESSMESSAGE = "SUCCESS";

    public static String FAILCODE="10001";
    public static String FAILMESSAGE="FAIL";

    public static String EXCEPTCODE = "10002";
    public static String EXCEPTMESSAGE="EXCEPT";

    public static String NANCODE = "10003";
    public static String NANMESSAGE="NANDATA";

    public static String outofmax= "10004";
    public static String outofmaxmaxmessage="out of maxsize";

    public static String lackpam = "10005";
    public static String lackPamMessage="missing parameter";

    public static String parmVali = "10006";
    public static String parmValiMessage= "Parameter exception";

    public static String other = "10100";
    public static String otherMessage="other fail";


    public static Map<String,Object> getSuccess(Object data){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("code",SUCCESSCODE);
        map.put("message",SUCCESSMESSAGE);
        map.put("data",data);
        return map;
    }

    public static Map<String ,Object> getFail(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("code",FAILCODE);
        map.put("message",FAILMESSAGE);
        return map;
    }

    public static Map<String,Object> getExcept(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("code",EXCEPTCODE);
        map.put("message",EXCEPTMESSAGE);
        return map;
    }

    public static Map<String,Object> getNan(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("code",NANCODE);
        map.put("message",NANMESSAGE);
        return map;
    }

    public static Map<String,Object> getOutOfMaxSize(String message){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("code",outofmax);
        map.put("message",outofmaxmaxmessage);
        map.put("data",message);
        return map;
    }

    public static Map<String,Object> getMissParament(String msg){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("code",lackpam);
        map.put("message",lackPamMessage);
        map.put("data",msg);
        return map;
    }

    public static Map<String,Object> getParameterExcept(String msg){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("code",parmVali);
        map.put("message",parmValiMessage);
        map.put("data",msg);
        return map;
    }

    public static Map<String,Object> getOtherFail(String msg){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("code",other);
        map.put("message",otherMessage);
        map.put("data",msg);
        return map;
    }
}
