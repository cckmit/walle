package com.panpan.walle.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class HelloController {

    @NacosValue(value = "${myname:world}", autoRefreshed = true)
    private String name;

    @RequestMapping("index")
    public String hello(){
        return "hello:" + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
