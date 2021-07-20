package com.panpan.walle.study.jjkj;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RETest {

    @Test
    public void RETest(){
        String s = "李琦进一步搜索了上海瑞代医疗科技股份有限公司企业的中证网登记信息，搜索的关键字数量为2";
        Pattern pattern = Pattern.compile("\\S+搜索了(\\S+)企业的中证网登记信息，搜索的关键字数量为(\\d+)");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find())
            System.out.println(matcher.group(1) + "," + matcher.group(2));
    }

    @Test
    public void ReplaceTest(){
        String s = "李琦进一步搜索了上海瑞代医疗科技股份有限公司企业的中证网登记信息，搜索的关键字数量为2";
        s = s.replaceAll("\\S+搜索了(\\S+)企业的中证网登记信息，搜索的关键字数量为(\\d+)", "$1,$2");
        System.out.println(s);
    }
}
