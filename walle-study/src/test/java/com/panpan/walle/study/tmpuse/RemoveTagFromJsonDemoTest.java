package com.panpan.walle.study.tmpuse;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class RemoveTagFromJsonDemoTest {

    @Test
    void splitByTag() {
        //String content = FileUtil.readUtf8String("D:\\orcResult_20210902103149591.txt");
        String content = FileUtil.readUtf8String("D:\\orcResult_20210902105354978.txt");
        String targetTag = "content_all";
        TimeInterval timeInterval = new TimeInterval();
        JSONObject json = JSON.parseObject(content);
        String contentAll = json.getJSONObject("data").getJSONArray("content_all").toJSONString();
        System.out.println(StrUtil.format("step111-用时 {} ms", timeInterval.intervalRestart()));
        int[] pos = RemoveTagFromJsonDemo.splitByTag(content, targetTag);
        System.out.println(StrUtil.format("step222-用时 {} ms", timeInterval.intervalRestart()));
        String contentAll2 = null;
        if (pos[0] > 0){
            contentAll2 = StrUtil.sub(content, pos[0]+ targetTag.length() + 4, pos[1]-2);
        }
        System.out.println(StrUtil.format("step333-用时 {} ms", timeInterval.intervalRestart()));
        Assert.assertEquals(true, helper(contentAll, contentAll2));
        System.out.println(StrUtil.format("step444-用时 {} ms", timeInterval.intervalRestart()));
        String contentLeft = StrUtil.sub(content, 0, pos[0]) + StrUtil.sub(content, pos[1], content.length());
        System.out.println(StrUtil.format("step555-用时 {} ms", timeInterval.intervalRestart()));
        JSONObject jsonLeft = JSON.parseObject(contentLeft);
        System.out.println(StrUtil.format("step666-用时 {} ms", timeInterval.intervalRestart()));
    }

    /**
     * 优化前
     */
    @Test
    public void testBeforeModify() throws InterruptedException {
        String content = FileUtil.readUtf8String("D:\\orcResult_20210902105354978.txt");
        TimeInterval timeInterval = new TimeInterval();
        JSONObject json = JSON.parseObject(content);
        System.out.println(StrUtil.format("step111-用时 {} ms", timeInterval.intervalRestart()));

        TimeUnit.SECONDS.sleep(60);
    }

    /**
     * 优化后
     */
    @Test
    public void testAfterModify() throws InterruptedException {
        String content = FileUtil.readUtf8String("D:\\orcResult_20210902105354978.txt");
        String targetTag = "content_all";
        TimeInterval timeInterval = new TimeInterval();

        int[] pos = RemoveTagFromJsonDemo.splitByTag(content, targetTag);
        System.out.println(StrUtil.format("step222-用时 {} ms", timeInterval.intervalRestart()));
        String contentAll2 = null;
        if (pos[0] > 0){
            contentAll2 = StrUtil.sub(content, pos[0]+ targetTag.length() + 4, pos[1]-2);
        }
        System.out.println(StrUtil.format("contentALl长度:{}", contentAll2.length()));
        String contentLeft = StrUtil.sub(content, 0, pos[0]) + StrUtil.sub(content, pos[1], content.length());
        System.out.println(StrUtil.format("step555-用时 {} ms", timeInterval.intervalRestart()));
        JSONObject jsonLeft = JSON.parseObject(contentLeft);

        TimeUnit.SECONDS.sleep(60);

    }

    private boolean helper(String json1, String json2){
        JSONArray j1 = JSON.parseArray(json1);
        JSONArray j2 = JSON.parseArray(json2);

        return 0 == StrUtil.compare(j1.toJSONString(), j2.toJSONString(), true);
    }
}