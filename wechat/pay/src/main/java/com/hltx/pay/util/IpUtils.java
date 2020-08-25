package com.hltx.pay.util;

import java.net.InetAddress;
import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/10
 * Time: 14:17
 * Description:
 */
public class IpUtils {

    public static String getIp() {
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();

            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
            return localip;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
