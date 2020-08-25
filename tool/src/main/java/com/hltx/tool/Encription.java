package com.hltx.tool;

import com.hltx.tool.encryption.DES;
import com.hltx.tool.encryption.DES3;
import org.apache.commons.codec.binary.Base64;
import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: ycj
 * Date: 2020/7/30
 * Time: 14:03
 * Description: 常用加密算法
 */
public class Encription {

    public static byte[] encode2Base64(byte[] bytes) {
        byte[] bts = Base64.encodeBase64(bytes);
        return bts;
    }
    public static byte[] decode2Base64(String str) {
        byte[] bts = Base64.decodeBase64(str);
        return bts;
    }

    public static String md5(String str) {
        try {
            //dataStr = dataStr + slat;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(str.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static byte[] sha1ToBytes(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] bts = digest.digest(str.getBytes());
            return bts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String createkey(){
        return DES.createSecKey(16);
    }

    public static Map<String,String> encryptDes(String data){
        Map<String,String> map=new HashMap<String, String>();
        String key=createkey();
        String pwd=DES.encrypt(data,key);
        map.put("key",key);
        map.put("pwd",pwd);
        return map;
    }

    public static String encryptDes(String data, String key){
       return DES.encrypt(data,key);
    }

    public static byte[] encryptDes(byte[] src,String key){
        return DES.encrypt(src, key);
    }

    public static Map<String ,Object> encryptDes(byte[] src){
        String key=createkey();
        byte[] pwd=DES.encrypt(src,key);
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("key",key);
        map.put("pwd",pwd);
        return map;
    }

    public static String decrypt(String data, String key ) throws Exception {
        return DES.decrypt(data, key);
    }

    public static byte[] decrypt(byte[] src, String password) throws Exception {
        return DES.decrypt(src, password);
    }

    public static String encode3Des(String key,String srcStr,String type){
        return DES3.encode3Des(key, srcStr, type);
    }

    public static String decode3Des(String key,String srcStr,String type){
        return DES3.decode3Des(key, srcStr, type);
    }

    public static byte[] encode3Desbyte(String key, String srcStr, String type){
        return DES3.encode3Desbyte(key, srcStr, type);
    }

    public static String decode3Desbyte(String key, byte[] src,String type){
        return DES3.decode3Desbyte(key, src, type);
    }

    public static void main(String[] args) {
        System.out.println(md5("123456"));
    }
}
