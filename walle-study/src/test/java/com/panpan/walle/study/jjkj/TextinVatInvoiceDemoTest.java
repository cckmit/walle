package com.panpan.walle.study.jjkj;

import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TextinVatInvoiceDemoTest extends TestCase {

    //发票验真
    private static final String VAT_INVOICE = "https://api.textin.com/robot/v1.0/api/verify_vat";

    public static final String APP_ID = "51c3b67d287e03d870b3a1405978ee30-111";
    public static final String SECRET_CODE = "670d5b6a11380c0b4f9a268f5e9fa9f3";

    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * 测试增值税普通发票凭证
     */
    @Test
    public void testCommonInvoiceProof(){
        Map<String, String> body = new HashMap<>();
        body.put("invoice_date", "20181220");
        body.put("invoice_code", "3700174350");
        body.put("invoice_no", "00142202");
        body.put("verify_code", "271591");
        //body.put("invoice_sum", "779816.51");

        HttpResponse response = HttpRequest
                .post(VAT_INVOICE)
                .header("x-ti-app-id",APP_ID)
                .header("x-ti-secret-code",SECRET_CODE)
                .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                .body(JSON.toJSONString(body))
                .execute();

        System.out.println(JSON.toJSONString(JSON.parseObject(response.body()), SerializerFeature.PrettyFormat));
    }
}