package com.panpan.walle.study.jjkj;

import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TextinVatInvoiceDemo {

    //发票验真
    private static final String VAT_INVOICE = "https://api.textin.com/robot/v1.0/api/verify_vat";

    public static final String APP_ID = "51c3b67d287e03d870b3a1405978ee30";
    public static final String SECRET_CODE = "670d5b6a11380c0b4f9a268f5e9fa9f3";
    static CountDownLatch countDownLatch = new CountDownLatch(500);
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500; i++){
            threadPool.submit(()->testCommonInvoice());
        }

        countDownLatch.await();
        System.out.println("用时:"+(System.currentTimeMillis()-start) + "ms");
        threadPool.shutdown();
    }

    private static void testSpecialInvoice(){
        Map<String, String> body = new HashMap<>();
        body.put("invoice_date", "20200518");
        body.put("invoice_code", "3502194130");
        body.put("invoice_no", "00958188");
        body.put("verify_code", "120979");
        body.put("invoice_sum", "779816.5");

        //"all_tax":"70183.49",
        //"invoice_money":"779816.51",
        //"all_valorem_tax":"850000.00",
        HttpResponse response = HttpRequest
                .post(VAT_INVOICE)
                .header("x-ti-app-id",APP_ID)
                .header("x-ti-secret-code",SECRET_CODE)
                .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                .body(JSON.toJSONString(body))
                .execute();
        System.out.println(Thread.currentThread().getName() + ":" + response.body());
        countDownLatch.countDown();

        //System.out.println(JSON.toJSONString(JSON.parseObject(response.body()), SerializerFeature.PrettyFormat));
    }

    private static void testCommonInvoice() {
        Map<String, String> body = new HashMap<>();
        body.put("invoice_date", "20210529");
        body.put("invoice_code", "031002000311");
        body.put("invoice_no", "41816631");
        body.put("verify_code", "281159");
        //body.put("invoice_sum", "45.00");

        HttpResponse response = HttpRequest
                .post(VAT_INVOICE)
                .header("x-ti-app-id",APP_ID)
                .header("x-ti-secret-code",SECRET_CODE)
                .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                .body(JSON.toJSONString(body))
                .execute();
        countDownLatch.countDown();
        System.out.println(Thread.currentThread().getName() + ":" + response.body());
        //System.out.println(JSON.toJSONString(JSON.parseObject(response.body()), SerializerFeature.PrettyFormat));
    }


}
