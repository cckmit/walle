package com.panpan.walle.study.jjkj;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceCheckTest {

    private static final String AUTHORIZATION = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJPcmdJZCI6ODI2LCJsb2dpbk5hbWUiOiIxODUwMTYzNzQzNCIsImxvZ2luSXAiOiIxMC4zMC4yMi4xNiIsImV4cCI6MTYyNTcxMjEwNiwidXNlcklkIjo5NzQsImNyZWF0ZURhdGUiOjE2MjU3MDg1MDZ9.Ocrb6HnL0oHXdvCRH9ma8M3X3CSGSGHb4kWS3rLRgaE";



    /**
     * 查询发票验真结果
     */
    @Test
    public void testQueryInvoiceResult(){
        String URL = "http://localhost:8089/fin/sbdo/billCheck/selectPageByBatchNo";

        Map<String, Object> params = new HashMap<>();
        params.put("current",1);
        params.put("pageSize",10);
        params.put("batchNo","TX20190605002900");
        params.put("index", 0);

        Map<String, Object> body = new HashMap<>();
        body.put("data", Base64.encode(JSON.toJSONString(params)));

        HttpResponse response = HttpRequest
                .post(URL)
                .header("authorization", AUTHORIZATION)
                .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                .body(JSON.toJSONString(body))
                .execute();

        if (response != null)
        {
            String resp = Base64.decodeStr((String)JSON.parseObject(response.body(), Map.class).get("data"));
            System.out.println(JSON.toJSONString(JSON.parseObject(resp), SerializerFeature.PrettyFormat));
            Assert.assertEquals(true, resp.contains("billState"));
        };


    }

    /* 发票OCR识别
     */
    @Test
    public void testTextinOCR(){
        String ORC_URL = "http://localhost:8089/comm/file/uploadAndOcrForInvoicePDF";
        String FILE = "D:\\OneDrive\\Documents\\聚均科技\\20210623-发票验真\\测试发票-肯德基.pdf";


        HttpResponse response = HttpRequest
                .post(ORC_URL)
                .header("authorization", AUTHORIZATION)
                .header(Header.CONTENT_TYPE, ContentType.MULTIPART.getValue())
                .form("file", new File(FILE))
                .execute();

        if (response != null){
            System.out.println(response.body());
        }

    }

    /**
     * 发票验真
     */
    @Test
    public void testVatOneInvoice(){
        String URL = "http://localhost:8089/fin/sbdo/billCheck/batchCheck";

        Map<String, Object> params = new HashMap<>();
        List<Integer> idList = new ArrayList<>();

        for (int i = 6802; i <= 7100; i++) idList.add(i);
//        idList.add(6787);
//        idList.add(6788);
//        idList.add(6602);
        params.put("idList", idList);

        Map<String, Object> body = new HashMap<>();
        body.put("data", Base64.encode(JSON.toJSONString(params)));

        HttpResponse response = HttpRequest
                .post(URL)
                .header("authorization", AUTHORIZATION)
                .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                .body(JSON.toJSONString(body))
                .execute();

        if (response != null)
        {
            String resp = Base64.decodeStr((String)JSON.parseObject(response.body(), Map.class).get("data"));
            System.out.println(resp);
        };
    }

    /**
     * 添加单张发票
     */
    @Test
    public void testAddBill001(){

        String ADDBILL_URL = "http://localhost:8089/fin/sbdo/billCheck/addBill";

        Map<String, Object> params = new HashMap<>();
        params.put("billLine", "p");
        params.put("billDate", "20181220");
        params.put("billCode", "3700174350");
        params.put("billNo", "00142202");
        params.put("billCheckCode", "271591");
        params.put("billNoTaxAmt", "27051.00");

        Map<String, Object> body = new HashMap<>();
        body.put("data", Base64.encode(JSON.toJSONString(params)));

        HttpResponse response = HttpRequest
                .post(ADDBILL_URL)
                .header("authorization", AUTHORIZATION)
                .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                .body(JSON.toJSONString(body))
                .execute();

        if (response != null)
        {
            String resp = Base64.decodeStr((String)JSON.parseObject(response.body(), Map.class).get("data"));
            System.out.println(resp);
        };

    }

    /**
     * 添加单张发票
     */
    @Test
    public void testAddBill002(){

        String ADDBILL_URL = "http://localhost:8089/fin/sbdo/billCheck/addBill";

        Map<String, Object> params = new HashMap<>();
        params.put("billLine", "p");
        params.put("billDate", "20210529");
        params.put("billCode", "031002000311");
        params.put("billNo", "41816631");
        params.put("billCheckCode", "281159");
        params.put("billNoTaxAmt", "42.45");

        Map<String, Object> body = new HashMap<>();
        body.put("data", Base64.encode(JSON.toJSONString(params)));

        HttpResponse response = HttpRequest
                .post(ADDBILL_URL)
                .header("authorization", AUTHORIZATION)
                .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                .body(JSON.toJSONString(body))
                .execute();

        if (response != null)
        {
            String resp = Base64.decodeStr((String)JSON.parseObject(response.body(), Map.class).get("data"));
            System.out.println(resp);
        };

    }
}
