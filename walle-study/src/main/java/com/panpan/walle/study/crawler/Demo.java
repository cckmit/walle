package com.panpan.walle.study.crawler;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Demo {
    public static void main(String[] args)  throws Exception {

        // 此例子需要 httpclient4.5.3 以上版本
        String ProxyAddr = "183.166.160.184"; // 代理地址
        int ProxyPort = 57114;              // 端口
        String ProxyUser = "rikei666";     // 平台帐号
        String ProxyPasswd = "rikei1234";      // 密码

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(ProxyAddr, ProxyPort),
                new UsernamePasswordCredentials(ProxyUser, ProxyPasswd));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();
        try {
            HttpHost target = new HttpHost("www.baidu.com", 443, "https");
            HttpHost proxy = new HttpHost(ProxyAddr, ProxyPort);

            RequestConfig config = RequestConfig.custom()
                    .setProxy(proxy)
                    .build();
            HttpGet httpget = new HttpGet("/");
            httpget.setConfig(config);
            httpget.setHeader("User-Agent","curl/0.7.6");

            System.out.println("Executing request " + httpget.getRequestLine() + " to " + target + " via " + proxy);

            CloseableHttpResponse response = httpclient.execute(target, httpget);
            //response.setLocale(Locale.CHINESE);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
