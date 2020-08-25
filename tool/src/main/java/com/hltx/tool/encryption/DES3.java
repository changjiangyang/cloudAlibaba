package com.hltx.tool.encryption;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * User: ycj
 * Date: 2020/7/30
 * Time: 15:00
 * Description: 3DES加密 解密工具类
 */
public class DES3 {

    public static byte[] hex(String key){
        String f = DigestUtils.md5Hex(key);
        byte[] bkeys = new String(f).getBytes();
        byte[] enk = new byte[24];
        for (int i=0;i<24;i++){
            enk[i] = bkeys[i];
        }
        return enk;
    }

    /**
     * 3DES加密
     * @param key 密钥，24位
     * @param srcStr 将加密的字符串
     * @return
     *
     * lee on 2017-08-09 10:51:44
     */
    public static String  encode3Des(String key,String srcStr,String type){
        byte[] keybyte = hex(key);
        byte[] src = srcStr.getBytes();
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
            //加密
            Cipher c1 = Cipher.getInstance("DESede"+type);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            String pwd = Base64.encodeBase64String(c1.doFinal(src));
            //return c1.doFinal(src);//在单一方面的加密或解密
            return pwd;
        } catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        }catch(javax.crypto.NoSuchPaddingException e2){
            e2.printStackTrace();
        }catch(Exception e3){
            e3.printStackTrace();
        }
        return null;
    }

    /**
     * 3DES解密
     * @param key 加密密钥，长度为24字节
     * @param desStr 解密后的字符串
     * @return
     * lee on 2017-08-09 10:52:54
     */
    public static String decode3Des(String key, String desStr,String type){
        Base64 base64 = new Base64();
        byte[] keybyte = hex(key);
        byte[] src = base64.decode(desStr);
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
            //解密
            Cipher c1 = Cipher.getInstance("DESede"+type);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            String pwd = new String(c1.doFinal(src));
            //return c1.doFinal(src);
            return pwd;
        } catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        }catch(javax.crypto.NoSuchPaddingException e2){
            e2.printStackTrace();
        }catch(Exception e3){
            e3.printStackTrace();
        }
        return null;
    }

    public static byte[] encode3Desbyte(String key,String srcStr,String type){
        byte[] keybyte = hex(key);
        byte[] src = srcStr.getBytes();
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
            //加密
            Cipher c1 = Cipher.getInstance("DESede"+type);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            byte[] pwd= c1.doFinal(src);
            //return c1.doFinal(src);//在单一方面的加密或解密
            return pwd;
        } catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        }catch(javax.crypto.NoSuchPaddingException e2){
            e2.printStackTrace();
        }catch(Exception e3){
            e3.printStackTrace();
        }
        return null;
    }

    public static String decode3Desbyte(String key, byte[] src,String type){
        byte[] keybyte = hex(key);
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
            //解密
            Cipher c1 = Cipher.getInstance("DESede"+type);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            String pwd = new String(c1.doFinal(src));
            return pwd;
        } catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        }catch(javax.crypto.NoSuchPaddingException e2){
            e2.printStackTrace();
        }catch(Exception e3){
            e3.printStackTrace();
        }
        return null;
    }

}
