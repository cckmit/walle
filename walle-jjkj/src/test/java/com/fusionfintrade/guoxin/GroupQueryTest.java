package com.fusionfintrade.guoxin;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fusionfintrade.common.FusionHttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 国新项目测试用
 */
public class GroupQueryTest  {

    private String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJPcmdJZCI6MzEsImxvZ2luTmFtZSI6IkVFMDAwMUVFNjcxMDNDOEMyQjZBMzQxQUJBRjdGMUUwIiwibG9naW5JcCI6IjEwLjMwLjIyLjE2IiwiZXhwIjoxNjMxODQ0NDYwLCJ1c2VySWQiOjEzOSwiY3JlYXRlRGF0ZSI6MTYzMTg0MDg2MH0.UblY6QVEIZ8SsTlWRB7lgqu9Buol4-pLKlBBVAmUBWo";
    private static String baseURL = "http://localhost:8087/";

    /**
     * 集团应收账款查询-应收账款合计
     */
    @Test
    public void collectSupplierTest(){
        String url = "scdb/debtM/collectSupplier";

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("supplierOrgName","A");
        reqBody.put("supplierOrgCode","A1");
        reqBody.put("payablerOrgName","B");
        reqBody.put("payablerOrgCode","B1");
        reqBody.put("receivableDeadline","20210909");

        Map<String, Object> respMap = FusionHttpUtil.request(baseURL+url, token, reqBody);
        System.out.println(JSON.toJSONString(respMap, SerializerFeature.PrettyFormat));
    }


    /**
     * 集团应收账款查询-应收账款导出
     */
    @Test
    public void collectSupplierXlsxTest(){
        String url = "scdb/debtM/exportSupplierXlsx";

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("supplierOrgName","A");
        reqBody.put("supplierOrgCode","A1");
        reqBody.put("payablerOrgName","B");
        reqBody.put("payablerOrgCode","B1");
        reqBody.put("receivableDeadline","20210909");


        Map<String, Object> respMap = FusionHttpUtil.request(baseURL + url, token, reqBody);

        System.out.println(JSON.toJSONString(respMap, SerializerFeature.PrettyFormat));

        Map<String, String> map = (Map<String, String>) respMap.get("data");
        String fileName =map.get("fileName");
        byte[] content = Base64.decode(map.get("fileContent").replace("data:application/x-xls;base64,",""));
        FileUtil.writeBytes( content, fileName);
        System.out.println(StrUtil.format("生成的文件路径:{}", fileName));

    }

    /**
     * 集团应收账款查询-应付账款导出
     */
    @Test
    public void exportPayablerXlsxTest(){
        String url = "scdb/debtM/exportPayablerXlsx";

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("supplierOrgName","A");
        reqBody.put("supplierOrgCode","A1");
        reqBody.put("payablerOrgName","B");
        reqBody.put("payablerOrgCode","B1");
        reqBody.put("receivableDeadline","20210909");


        Map<String, Object> respMap = FusionHttpUtil.request(baseURL + url, token, reqBody);

        System.out.println(JSON.toJSONString(respMap, SerializerFeature.PrettyFormat));

        Map<String, String> map = (Map<String, String>) respMap.get("data");
        String fileName =map.get("fileName");
        byte[] content = Base64.decode(map.get("fileContent").replace("data:application/x-xls;base64,",""));
        FileUtil.writeBytes( content, fileName);
        System.out.println(StrUtil.format("生成的文件路径:{}", fileName));

    }
}
