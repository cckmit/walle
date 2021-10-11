package com.panpan.walle.study.crawler.dailiyun;

import lombok.Data;

@Data
public class ProxyEntry {
    private String userName;

    private String password;

    private String host;

    private int port;

    /**
     * 已使用次数
     */
    private int times;

    /**
     * 最近一次使用延时
     */
    private long delay;

    public ProxyEntry(String userName, String password, String host, int port, int times, long delay) {
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.port = port;
        this.times = times;
        this.delay = delay;
    }

    private long borrowTimestamp;

    @Override
    public String toString() {
        return "ProxyEntry{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", times=" + times +
                ", delay=" + delay +
                '}';
    }
}
