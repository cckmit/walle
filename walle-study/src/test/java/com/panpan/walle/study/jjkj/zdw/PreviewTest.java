package com.panpan.walle.study.jjkj.zdw;

import cn.hutool.http.*;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class PreviewTest {
public static final String AUTHORIZATION= "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJPcmdJZCI6OSwibG9naW5OYW1lIjoiMTgzMjEyNzAwMDAiLCJsb2dpbklwIjoiMTAuMzAuMjIuMTYiLCJleHAiOjE2MjU4MDYwODEsInVzZXJJZCI6MTk3LCJjcmVhdGVEYXRlIjoxNjI1ODAyNDgxfQ.CfW7v6KVmxo7MwRIMyeaivh1H1cV3MziI4qV1LEnyR0";

    @Test
    public void testPreviewSlow(){
        String body = "{\"keyWordList1\":[],\"keyWordList2\":[],\"checkInNo\":\"00422907000049950997\",\"orgName\":\"上海润达医疗科技股份有限公司\",\"filename\":\"质押登记.pdf\",\"url\":\"zdw/00422907000049950997/质押登记.pdf\",\"index\":30,\"pageSize\":10}";
        String URL = "http://localhost:8300/api/szdw/assetCheckIn/preview";
        System.out.println(body);
//        HttpResponse response = HttpRequest
//                .post(URL)
//                .header("authorization", AUTHORIZATION)
//                .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
//                .body(JSON.toJSONString(body))
//                .execute();
//
//        System.out.println(response.body());

    }
}
