package com.hltx.pay.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/10
 * Time: 14:05
 * Description:
 */
public class test {

    public static void main(String[] args) {
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();

            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<String> list= getLocalIPList();
        System.out.println(list.toString());
    }

    public static List<String> getLocalIPList() {
        List<String> ipList = new ArrayList<String>();
        Enumeration<NetworkInterface> networkInterfaces = null;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        NetworkInterface networkInterface;
        Enumeration<InetAddress> inetAddresses;
        InetAddress inetAddress;
        String ip;
        while (networkInterfaces.hasMoreElements()) {
            networkInterface = networkInterfaces.nextElement();
            inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                inetAddress = inetAddresses.nextElement();
                if (inetAddress != null && inetAddress instanceof Inet4Address) { // IPV4
                    ip = inetAddress.getHostAddress();
                    ipList.add(ip);
                }
            }
        }
        return ipList;
    }
}
