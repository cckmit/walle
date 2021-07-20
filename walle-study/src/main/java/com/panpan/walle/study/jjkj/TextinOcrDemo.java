package com.panpan.walle.study.jjkj;

import cn.hutool.core.io.IoUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextinOcrDemo {
    //发票OCR识别
    private static final String VAT_INVOICE = "https://api.textin.com/robot/v1.0/api/bills_crop";

    public static final String APP_ID = "51c3b67d287e03d870b3a1405978ee30";
    public static final String SECRET_CODE = "670d5b6a11380c0b4f9a268f5e9fa9f3";

    public static String fileImage = "C:\\Users\\lipan\\Downloads\\2021-06-24_14-21-20.jpg";
    public static String filePdf = "C:\\Users\\lipan\\Downloads\\f6d3dad9b39c623615f46bf440cfca202c325d.pdf";
    private static Logger logger = LoggerFactory.getLogger(TextinOcrDemo.class);

    public static void main(String[] args) throws FileNotFoundException {
        HttpResponse response = HttpRequest
                .post(VAT_INVOICE)
                .header("x-ti-app-id",APP_ID)
                .header("x-ti-secret-code",SECRET_CODE)
                //.body(IoUtil.readBytes(new FileInputStream(fileImage)))
                .body(IoUtil.readBytes(new FileInputStream(filePdf)))
                .execute();

        //System.out.println(JSON.toJSONString(JSON.parseObject(response.body()), SerializerFeature.PrettyFormat));
        JSONObject resp = JSONObject.parseObject(response.body());
        JSONObject resultObject = (JSONObject) resp.get("result");
        JSONArray objectList = (JSONArray) resultObject.get("object_list");
        logger.info("发票识别的内容:{}", JSON.toJSONString(objectList));

        if (objectList != null) {
            for (JSONObject jsonObject: objectList.toJavaList(JSONObject.class)){
                // 发票种类
                String invoiceType = (String) jsonObject.get("type_description");
                if (!StringUtils.isEmpty(invoiceType) && !invoiceType.equals("无")) {
                    if (invoiceType.contains("专用发票")) {
                        logger.info("专用发票");
                    } else if (invoiceType.contains("普通发票")) {
                        logger.info("普通发票");
                    }
                }

                //获取明细信息
                List<Map<String, Object>> itemList = jsonObject.getObject("item_list", List.class);
                Map<String, String> itemMap = new HashMap<>();
                itemList.stream().forEach(e-> itemMap.put((String) e.get("key"), (String) e.get("value")));

                System.out.println("发票号码：" + itemMap.get("vat_invoice_haoma_right_side"));
                System.out.println(JSON.toJSONString(itemMap));
            }

        }
    }
}
