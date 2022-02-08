package com.zaqbest.walle.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value="helloworld", notes="helloworld")
    @PostMapping("index")
    public RespVo hello(@RequestBody ReqVo reqVo){
        return new RespVo(reqVo.getValue());
    }

    @ApiOperation(value="query", notes="query")
    @PostMapping("query")
    public RespVo query(@RequestBody ReqVo reqVo){
        return new RespVo("1000");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
