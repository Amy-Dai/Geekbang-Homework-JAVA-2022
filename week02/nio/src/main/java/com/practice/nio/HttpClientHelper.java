package com.practice.nio;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class HttpClientHelper {
    public static CloseableHttpClient httpclient = HttpClients.createDefault();

    // GET 调用
    public static String getAsString(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("mao","dddmo");
        CloseableHttpResponse response1 = null;
        try {
            response1 = httpclient.execute(httpGet);
            HttpEntity entity1 = response1.getEntity();
            return EntityUtils.toString(entity1, "UTF-8");
        } finally {
            if (null != response1) {
                response1.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8888";
        String text = HttpClientHelper.getAsString(url);
        System.out.println("url: " + url + " ; response: \n" + text);

        String testURL = url + "/test";
        System.out.println("testURL: " + testURL + "; response: \n" + HttpClientHelper.getAsString(testURL));
    }
}
