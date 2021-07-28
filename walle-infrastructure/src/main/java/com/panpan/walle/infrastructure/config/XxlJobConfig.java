package com.panpan.walle.infrastructure.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

@SuppressWarnings("ALL")
@Configuration
@Slf4j
@ConditionalOnProperty(prefix="walle-app",name = "enableXxlJob", havingValue = "true")
public class XxlJobConfig {

    @NacosValue("${xxl.job.admin.addresses}")
    private String adminAddresses;

    @NacosValue("${xxl.job.executor.appname}")
    private String appName;

    @NacosValue("${xxl.job.executor.port}")
    private int port;

    @NacosValue("${xxl.job.accessToken}")
    private String accessToken;

    @NacosValue("${xxl.job.executor.logpath}")
    private String logPath;

    @NacosValue("${xxl.job.executor.logretentiondays}")
    private int logRetentionDays = -1;

    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info("==> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appName);
        xxlJobSpringExecutor.setIp(getFixIpAddress());
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);
        return xxlJobSpringExecutor;
    }

    public static String getFixIpAddress(){
        return "10.10.1.1";
    }

    public static String getIpAddress() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("IP地址获取失败", e);
        }
        return "";
    }
}
