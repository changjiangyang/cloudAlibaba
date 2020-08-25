package com.hltx.tool;

import okhttp3.Request;

import java.io.*;
import java.net.Socket;

/**
 * User: ycj
 * Date: 2020/7/31
 * Time: 14:37
 * Description:
 */
public class test {

    public static void main(String[] args) {
        String log="C32B816D6B0118D908E7300D5E84110F110205191213KN350900000000000000";

        byte []body=log.getBytes();
        byte xor=getXor(body);
        byte [] bytes=new byte[body.length+34];
        bytes[0]=0x01;
        byte length= 0x00;
        byte index= 0x00,count=0x00,version=0x01;
        byte[] sessionID=new byte[16];
        byte status= 0x01,end=0x01;
        byte [] xors=new byte[]{xor};
        body=byteMerger(body,body.length,xors,1);


        length= (byte) body.length;

        byte [] message=bytes;
        message[1]=0x00;
        message[2]=index;
        message[3]=count;
        message[4]=version;
        message[5]= (byte) 0xFF;
        message[6]= (byte) 0xFF;
        message=byteMerger(message,7,sessionID,16);
        //message=byteMerger(message,14,body,body.length);
        message[message.length-2]=0x00;
        message[message.length-1]=0x01;
        String msg=bytesToHexString(message);
        System.out.println(msg);
       String res= sendmessage(message);
       System.out.println(res);
    }


    public static byte getXor(byte[] datas){

        byte temp=datas[0];

        for (int i = 1; i <datas.length; i++) {
            temp ^=datas[i];
        }

        return temp;
    }
    public static String sendmessage(byte[] message) {
        boolean flag = false;
        Socket s = null;
        try {
            s = new Socket("157.122.146.230", 9724);
            //s = new Socket("192.168.0.123",8888);
            //Log.d("sendmessage:",new String(message));
            s.setSoTimeout(10 * 1000);
            s.setTcpNoDelay(false);
            s.setOOBInline(false);
            OutputStream out = s.getOutputStream();
            out.write(message);
            byte[] buffer = new byte[1024 * 1024];

            InputStream inputStream = s.getInputStream();
            int length = inputStream.read(buffer);
            String msg = new String(buffer, 0, length, "utf8");
            System.out.println(msg);
            out.flush();
            out.close();
            return msg;
        } catch (Exception e1) {
            //e1.printStackTrace();
            e1.printStackTrace();
            return null;
        } finally {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //return false;
    }
    public static String bytesToHexString(byte[] src){

        StringBuilder stringBuilder = new StringBuilder();

        if (src == null || src.length <= 0) {

            return null;

        }

        for (int i = 0; i < src.length; i++) {

            int v = src[i] & 0xFF;

            String hv = Integer.toHexString(v);

            if (hv.length() < 2) {

                stringBuilder.append(0);

            }

            stringBuilder.append(hv);

        }

        return stringBuilder.toString();

    }


    public void  send02(String message) {
        //向远方发起TCP连接
        Socket s=null;
        try {
            s = new Socket("157.122.146.230", 9724);
            s.setSoTimeout(10 * 1000);
            //第二个参数为True则为自动flush
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(new OutputStreamWriter(
                            s.getOutputStream())), true);
            out.println(message);
            System.out.println("send签到" + message);
            byte[] buffer = new byte[1024 * 1024];
            byte[] res = new byte[1024 * 1024];
            InputStream inputStream = s.getInputStream();
            //DataInputStream input = new DataInputStream(inputStream);
            int length = inputStream.read(buffer);

            String allstr = new String(buffer, 0, 8, "utf8");

            int alllength = Integer.parseInt(allstr);
            while (length < alllength) {
                int len = inputStream.read(res);
                buffer = byteMerger(buffer, length, res, len);
                length = length + len;
            }
            System.out.println("send心跳" + buffer.length);
            String Msg = new String(buffer, 0, length, "utf8");

            System.out.println("send心跳back" + Msg);


        } catch (Exception e1) {
            //e1.printStackTrace();
            e1.printStackTrace();
            final String errMsg = e1.getMessage();
            System.out.println("sendexcept:" + errMsg);
        } finally {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static byte[] byteMerger(byte[] byte_1, int b1, byte[] byte_2,int b2){
        byte[] byte_3 = new byte[b1+b2];
        System.arraycopy(byte_1, 0, byte_3, 0, b1);
        System.arraycopy(byte_2, 0, byte_3, b1, b2);
        return byte_3;
    }
}
