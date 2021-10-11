package com.panpan.walle.study.crawler;

import com.panpan.walle.study.crawler.dailiyun.ProxyEntry;
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

import java.io.IOException;

public class HttpClientUtil {
    public static Boolean isValidProxy(ProxyEntry entry) {
        try{
            HttpHost target = HttpHost.create("https://www.baidu.com");
            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            credsProvider.setCredentials(
                    new AuthScope(entry.getHost(), entry.getPort()),
                    new UsernamePasswordCredentials(entry.getUserName(), entry.getPassword()));
            CloseableHttpClient httpclient = HttpClients.custom()
                    .setDefaultCredentialsProvider(credsProvider).build();
            try {
                HttpHost proxy = new HttpHost(entry.getHost(), entry.getPort());

                RequestConfig config = RequestConfig.custom()
                        .setProxy(proxy)
                        .build();
                HttpGet httpget = new HttpGet("/");
                httpget.setConfig(config);
                httpget.setHeader("User-Agent","curl/0.7.6");

                CloseableHttpResponse response = httpclient.execute(target, httpget);
                try {
                    return response.getStatusLine().getStatusCode() == 200;
                } finally {
                    response.close();
                }
            } finally {
                httpclient.close();
            }
        } catch (Exception e){
            return false;
        }
    }

    public static String request(String url, ProxyEntry entry) throws IOException {
        HttpHost target = HttpHost.create(url);
        String content = null;

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(entry.getHost(), entry.getPort()),
                new UsernamePasswordCredentials(entry.getUserName(), entry.getPassword()));
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5)
                .build();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setDefaultCredentialsProvider(credsProvider)
                .build();
        try {
            HttpHost proxy = new HttpHost(entry.getHost(), entry.getPort());

            RequestConfig config = RequestConfig.custom()
                    .setProxy(proxy)
                    .build();
            HttpGet httpget = new HttpGet("/");
            httpget.setConfig(config);
            httpget.setHeader("User-Agent","curl/0.7.6");

            //System.out.println("Executing request " + httpget.getRequestLine() + " to " + target + " via " + proxy);

            CloseableHttpResponse response = httpclient.execute(target, httpget);
            //response.setLocale(Locale.CHINESE);
            try {
                content = EntityUtils.toString(response.getEntity(), "utf-8");
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }

        return content;
    }

}
