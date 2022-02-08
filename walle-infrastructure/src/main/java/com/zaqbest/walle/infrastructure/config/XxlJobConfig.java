package com.zaqbest.walle.infrastructure.config;

import cn.hutool.core.util.StrUtil;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import com.zaqbest.walle.infrastructure.constant.AppConstant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Data
@ConditionalOnProperty(prefix= AppConstant.APP_NAME, name = "xxljob.enable", havingValue = "true")
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

    @Autowired
    private WalleConfig walleConfig;

    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info("==> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appName);
        xxlJobSpringExecutor.setIp(getIpAddress());
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);
        return xxlJobSpringExecutor;
    }

    public String getIpAddress() {

        //判断是否有固定IP地址（多网卡的情况）
        if (StrUtil.isNotEmpty(walleConfig.getXxlConfig().getFixIpAddress())) {
            return walleConfig.getXxlConfig().getFixIpAddress();
        }

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
