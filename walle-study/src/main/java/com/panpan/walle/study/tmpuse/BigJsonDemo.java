package com.panpan.walle.study.tmpuse;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.TimeUnit;

public class BigJsonDemo {
    public static void main(String[] args) throws InterruptedException {
        String content = FileUtil.readString("C:\\Users\\lipan\\Downloads\\resp.json", "UTF-8");
//        content = content.replaceAll("\"","");
//        content = content.replaceAll("\\\\","");
//        System.out.println(content.length());
//        JSONObject jsonObject = JSON.parseObject(content);
        while (true){
            TimeUnit.SECONDS.sleep(10);
        }
    }
}
