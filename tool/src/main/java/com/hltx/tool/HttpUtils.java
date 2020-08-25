package com.hltx.tool;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * User: ycj
 * Date: 2020/7/31
 * Time: 16:27
 * Description: Http 请求工具类
 */
public class HttpUtils {
    static OkHttpClient mClient;

    public HttpUtils(Integer timeout){
        mClient = new OkHttpClient();
        OkHttpClient.Builder builder = mClient.newBuilder();
        builder.connectTimeout(timeout, TimeUnit.SECONDS);
        builder.readTimeout(timeout, TimeUnit.SECONDS);
        builder.writeTimeout(timeout, TimeUnit.SECONDS);
        mClient = builder.build();
    }

    public HttpUtils(){
        mClient = new OkHttpClient();
        OkHttpClient.Builder builder = mClient.newBuilder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);
        mClient = builder.build();
    }

    /**
     * 分发失败的时候调用
     *
     * @param request
     * @param e
     * @param callBack
     */
    private static void deliverDataFailure(final Request request, final IOException e, final DataCallBack callBack) {
        /**
         * 在这里使用异步处理
         */
        new Thread(new Runnable() {
            public void run() {
                if (callBack != null) {
                    if(e==null)
                        callBack.requestFailure(request, new IOException());
                    else
                        callBack.requestFailure(request, e);
                }
            }
        }).start();
    }

    /**
     * 分发成功的时候调用
     *
     * @param result
     * @param callBack
     */
    private static void deliverDataSuccess(final String result, final DataCallBack callBack) {
        /**
         * 在这里使用异步线程处理
         */
        new Thread(new Runnable() {
            public void run() {
                if (callBack != null) {
                    try {
                        callBack.requestSuccess(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public interface DataCallBack {
        void requestFailure(Request request, IOException e);
        void requestSuccess(String result) throws Exception;
    }
    public static String sendGet(String url, Map<String,String> map,Map<String,String> hand){
        OkHttpClient okHttpClient = new OkHttpClient();
        if (map != null){
            url+="?";
            for (String key: map.keySet()) {
                String val=map.get(key);
                String pa=key+"+"+val+"&";
                url += pa;
            }
        }
        Request.Builder builder = new Request.Builder();
        if (hand != null){
            for (String key:hand.keySet()){
                builder.addHeader(key,hand.get(key));
            }
        }
        Request request=builder.url(url).build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public static String sendGet(String url, Map<String,String> map){
        if (map != null){
            url+="?";
            for (String key: map.keySet()) {
                String val=map.get(key);
                String pa=key+"+"+val+"&";
                url += pa;
            }
        }
        return sendGet(url);
    }

    public static String sendGet(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public void sendGetAsync(String url,final DataCallBack dataCallBack){
        final Request request = new Request.Builder().url(url).build();
        mClient.newCall(request).enqueue(new Callback() {

            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = null;
                try {
                    result = response.body().string();
                } catch (IOException e) {
                    deliverDataFailure(request, e, dataCallBack);
                }
                deliverDataSuccess(result, dataCallBack);
            }

            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                deliverDataFailure(request, e, dataCallBack);
            }
        });
    }

    public static String sendPost(String url){
        return sendPost(url,null,null);
    }

    public static String sendPost(String url,Map<String,String> map){
        return sendPost(url,map,null);
    }

    /*public static String sendPost(String url,Map<String,String> parameter,Map<String,String> header){
        OkHttpClient client = new OkHttpClient();
        // 创建一个请求 Builder
        Request.Builder builder = new Request.Builder();
        // 创建一个 request
        Request request = builder.url(url).build();

        // 创建一个 Headers.Builder
        Headers.Builder headerBuilder = request.headers().newBuilder();
        if (header !=null){
            for (String key:header.keySet()){
                headerBuilder.add(key, (String) header.get(key));
            }
        }
        FormBody.Builder requestBuilder = new FormBody.Builder();

        // 状态请求参数
        if (parameter !=null){
            for (String key:parameter.keySet()){
                requestBuilder.addEncoded(key, (String) parameter.get(key));
            }
        }

        builder.headers(headerBuilder.build()).post(requestBuilder.build());
        try  {
            Response execute = client.newCall(builder.build()).execute();
            return execute.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }*/

    public static String sendPost(String url, Map<String,String> map,Map<String,String> hander) {
        String sign = "";

        Set<String> set = map.keySet();
        for (String key : set) {
            sign += key + "=" + map.get(key) + "&";
        }

        sign = sign.substring(0, sign.length() - 1);
        System.out.println(sign);
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 1.获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 2.中文有乱码的需要将PrintWriter改为如下
            // out=new OutputStreamWriter(conn.getOutputStream(),"UTF-8")
            // 发送请求参数
            out.print(sign);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public void sendPostAsync(String url,final DataCallBack dataCallBack){
        sendPostAsync(url,null,dataCallBack);
    }

    public void sendPostAsync(String url,Map<String,String> params,final DataCallBack dataCallBack){
        sendPostAsync(url,params,null,dataCallBack);
    }

    public void sendPostAsync(String url,Map<String,String> params,Map<String ,String> headers,final DataCallBack dataCallBack){
        FormBody.Builder builder = new FormBody.Builder();
        if (params !=null){
            for (String key:params.keySet()){
                builder.add(key,params.get(key));
            }
        }
        RequestBody body = builder.build();
        Request.Builder builder1=new Request.Builder();
        if (headers != null){
            for (String key:headers.keySet())
                builder1.addHeader(key,headers.get(key));
        }
        final Request request = builder1.url(url).post(body).build();
        mClient.newCall(request).enqueue(new Callback() {
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                deliverDataFailure(request, e, dataCallBack);
            }

            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = null;
                try {
                    result = response.body().string();
                } catch (IOException e) {
                    deliverDataFailure(request, e, dataCallBack);
                }
                deliverDataSuccess(result, dataCallBack);
            }
        });
    }

    public static void sendPostAsyncJson(String url,String json,final DataCallBack dataCallBack){
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        final Request request =new Request.Builder().url(url).post(body).build();
        mClient.newCall(request).enqueue(new Callback() {
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                deliverDataFailure(request, e, dataCallBack);
            }

            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = null;
                try {
                    result = response.body().string();
                } catch (IOException e) {
                    deliverDataFailure(request, e, dataCallBack);
                }
                deliverDataSuccess(result, dataCallBack);
            }
        });
    }
}
