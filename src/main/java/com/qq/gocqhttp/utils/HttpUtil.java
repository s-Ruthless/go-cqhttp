package com.qq.gocqhttp.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtil {

    public String doGet(String url,int params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = "";
        try {
            //创建URIBuilder
            URIBuilder uriBuilder = new URIBuilder(url);
            //设置参数
            uriBuilder.setParameter("message_id", String.valueOf(params));
            //设置参数
            //创建httpGet远程连接实例
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            //httpGet.addHeader("Connection", "keep-alive");
            //设置请求头信息
            httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
            System.out.println("发起请求的信息："+httpGet);
            //执行get请求得到返回对象
            response = httpClient.execute(httpGet);
            //通过返回对象获取返回数据
            HttpEntity entity = response.getEntity();
            //通过EntityUtils中的toString方法将结果转换为字符串，后续根据需要处理对应的reponse code
            result = EntityUtils.toString(entity);
            System.out.println(result);

        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return result;
    }

    public String doPost(String url,String jsonStr) {
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = "";
        try {
            //创建http请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            //创建请求内容
            StringEntity entity = new StringEntity(jsonStr,"UTF-8");
            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return result;
    }

}


