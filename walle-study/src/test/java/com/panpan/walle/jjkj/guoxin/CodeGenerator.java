package com.panpan.walle.jjkj.guoxin;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import org.junit.Test;

import java.util.*;

public class CodeGenerator {


    @Test
    public void tmp(){
    Map<String, Object> map = new HashMap<>();
    map.put("aaa1", new Object());
    String name = Optional.ofNullable(map.get("aaa")).map(o->o.getClass().getName()).orElse("unknown");
        System.out.println(name);
    }


    @Test
    public void generateBean(){
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("", TemplateConfig.ResourceMode.CLASSPATH));
        Template template= engine.getTemplate("src/test/resources/guoxin/templates/template_bean.vm");

        String inputFile = "classpath:guoxin/data/bean_input.txt";
        List<String> lines = FileUtil.readUtf8Lines(inputFile);

        List<Field> fields = new ArrayList<>();
        for (String line: lines){
            if (StrUtil.isEmpty(line)) continue;

            String[] items = StrUtil.splitToArray(line, "\t");
            fields.add(new Field(items[2], items[1], items[0]));
        }

        Map<String, Object> params = new HashMap<>();
        params.put("fields", fields);
        String result =template.render(params);
        System.out.println(result);
    }

    @Test
    public void generateEnum(){
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("", TemplateConfig.ResourceMode.CLASSPATH));
        Template template= engine.getTemplate("src/test/resources/guoxin/templates/template_enum.vm");

        String inputFile = "classpath:guoxin/data/enum_input.txt";
        List<String> lines = FileUtil.readUtf8Lines(inputFile);

        List<Enum> enums = new ArrayList<>();
        for (String line: lines){
            if (StrUtil.isEmpty(line)) continue;

            String[] items = StrUtil.splitToArray(line, "\t");
            enums.add(new Enum(getEnumId(items[0]), items[0], StrUtil.trim(items[1])));
        }

        Map<String, Object> params = new HashMap<>();
        params.put("enums", enums);
        String result =template.render(params);
        System.out.println(result);
    }

    private String getEnumId(String input){
        if (NumberUtil.isNumber(input)){
            return "S"+input;
        }

        return input;
    }

}

