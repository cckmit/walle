package com.panpan.walle.jjkj.guoxin;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGenerator {

    @Test
    public void generateCode(){
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("", TemplateConfig.ResourceMode.CLASSPATH));
        Template template= engine.getTemplate("src/test/resources/guoxin/templates/template_cmb.vm");

        String inputFile = "classpath:guoxin/data/input.txt";
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

}

