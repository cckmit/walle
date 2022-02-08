package com.zaqbest.walle.start;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.zaqbest.walle.infrastructure.constant.AppConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = ("com.zaqbest.walle"))
@NacosPropertySource(dataId = AppConstant.DATA_ID, autoRefreshed = true)
@ImportResource("classpath:applicationContext.xml")
public class WalleStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalleStartApplication.class, args);
    }

}
