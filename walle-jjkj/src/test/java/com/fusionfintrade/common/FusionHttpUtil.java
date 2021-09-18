package com.fusionfintrade.common;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class FusionHttpUtil {
    public static Map<String, Object>  request(String url, String token, Object reqBody){
        HttpResponse response = HttpUtil.createPost(url)
                .header("authorization", token)
                .body(JSON.toJSONString(zip(reqBody)))
                .execute();

        return unzip(response.body());
    }

    private static Map<String, Object> zip(Object req){
        Map<String, Object> ret = new HashMap<>();
        ret.put("data", Base64.encode(JSON.toJSONString(req)));

        return ret;
    }

    private static Map<String, Object> unzip(String resp){
        return JSON.parseObject(Base64.decode((String)JSON.parseObject(resp, Map.class).get("data")), Map.class);
    }
}
