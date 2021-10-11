package com.panpan.walle.study.crawler.dailiyun;

import cn.hutool.http.HttpUtil;
import com.panpan.walle.study.crawler.HttpClientUtil;

import java.io.IOException;
import java.util.PriorityQueue;

/**
 * 获取代理IP地址
 */
public class DailiyunClient {
    private static String username = "rikei666";     // 平台帐号
    private static String password = "rikei1234";      // 密码

    private static final String REQUEST_URL = "http://rikei666.v4.dailiyun.com/query.txt?key=NPAF9FDC96&word=&count=5&rand=false&ltime=0&norepeat=false&detail=false";

    // 排序：使用次数少的，延时低的优先使用，
    private static PriorityQueue<ProxyEntry> cacheProxy = new PriorityQueue<ProxyEntry>((o1, o2) -> (int) (o1.getDelay() - o2.getDelay()));

    public static synchronized ProxyEntry borrowProxy(){

        if (cacheProxy.isEmpty()){
            pullProxyFromRemote();
        }

        ProxyEntry proxyEntry =  cacheProxy.poll();
        proxyEntry.setBorrowTimestamp(System.currentTimeMillis());
        return proxyEntry;
    }

    public static void returnProxy(ProxyEntry entry){
        System.out.println("开始回收entry:" + entry);
        entry.setTimes(entry.getTimes()+1);
        entry.setDelay(System.currentTimeMillis() - entry.getBorrowTimestamp());
        cacheProxy.offer(entry);
    }

    public static void destroyProxy(ProxyEntry entry){

    }

    public static void pullProxyFromRemote(){
        String response = HttpUtil.createGet(REQUEST_URL).execute().body();

        String[] proxyArray = response.split("\r\n");
        for (String proxy: proxyArray){
            String[] items = proxy.split(":");
            ProxyEntry entry = new ProxyEntry(username, password, items[0], Integer.valueOf(items[1]), 0, 0);
            if (HttpClientUtil.isValidProxy(entry)) {
                System.out.println("entry: " + entry + "验证通过，加入系统中");
                cacheProxy.offer(entry);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        ProxyEntry proxyEntry = null;

        for (int i = 0; i < 100; i++){
            System.out.println("正在处理第"+(i+1)+"次请求");
            try{
            proxyEntry = borrowProxy();
            System.out.println("proxyEntry:" + proxyEntry);

            String response  = HttpClientUtil.request("https://blog.ruo-shui.cn", proxyEntry);
            System.out.println("应答报文大小: "+ response.length());

            returnProxy(proxyEntry);
            } catch (Exception e){
                System.out.println("处理异常:" + e.getMessage());
                destroyProxy(proxyEntry);
            }
        }


    }
}
