package com.zaqbest.walle.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class WalleConfig {

    @Bean
    @ConfigurationProperties(prefix = "walleapp.xxljob")
    public XxlJob getXxlConfig(){
        return new XxlJob();
    }
}

@Data
class XxlJob{
    /**
     * 是否启用xxl功能
     */
    private String enable;

    /**
     * 是否指定IP地址（多网卡的情况）
     */
    private String fixIpAddress;
}
