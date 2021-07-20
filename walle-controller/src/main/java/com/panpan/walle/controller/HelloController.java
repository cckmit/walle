package com.panpan.walle.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "演示功能")
@RestController
@RequestMapping(path = "/")
public class HelloController {

    @NacosValue(value = "${myname:world}", autoRefreshed = true)
    private String name;

    @ApiOperation(value="helloworld", notes="helloworld")
    @GetMapping("index")
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
