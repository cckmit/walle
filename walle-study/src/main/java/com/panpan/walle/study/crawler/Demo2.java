package com.panpan.walle.study.crawler;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

public class Demo2 {
    public static void main(String[] args) {
        String ProxyAddr = "114.233.51.196"; // 代理地址
        int ProxyPort = 57114;              // 端口
        String ProxyUser = "rikei666";     // 平台帐号
        String ProxyPasswd = "rikei1234";      // 密码

        TimeInterval timeInterval = new TimeInterval();
        HttpResponse response = HttpUtil.createGet("https://2021.ip138.com")
                .basicProxyAuth(ProxyUser, ProxyPasswd)
                .setHttpProxy(ProxyAddr, ProxyPort)
                .execute();
        System.out.println("用时:"+timeInterval.interval());
        System.out.println(response.body());
    }
}
