package com.panpan.walle.study.jjkj.es;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.List;

public class ESTestSIT {
    //SIT
    //private static String URL="http://172.16.37.96:9200/${esIndex}/_doc/_search";

    //UAT
    //private static String URL="http://10.30.4.96:9200/${esIndex}/_doc/_search";

    //PROD
    private static String URL="http://121.199.164.75:9200/${esIndex}/_doc/_search";

    //private static String TEMPLETE="{\"query\":{\"bool\":{\"must\":[{\"match_phrase\":{\"checkInNo\":{\"query\":\"${check_in_no}\",\"slop\":0,\"zero_terms_query\":\"NONE\",\"boost\":1.0}}}],\"adjust_pure_negative\":true,\"boost\":1.0}},\"_source\":{\"includes\":[],\"excludes\":[\"content\",\"content_all\"]}}";
    private static String TEMPLETE="{\"query\":{\"bool\":{\"must\":[{\"match_phrase\":{\"checkInNo\":{\"query\":\"${check_in_no}\",\"slop\":0,\"zero_terms_query\":\"NONE\",\"boost\":1.0}}},{\"match_phrase\":{\"delFlag\":{\"query\":\"0\",\"slop\":0,\"zero_terms_query\":\"NONE\",\"boost\":1.0}}}],\"adjust_pure_negative\":true,\"boost\":1.0}},\"_source\":{\"includes\":[\"content\"],\"excludes\":[\"content\",\"content_all\"]}}";

    private static String TEMPLETE_OSSFILEPATH="{\"query\":{\"bool\":{\"must\":[{\"match_phrase\":{\"ossFileUrls\":{\"query\":\"${ossFilePath}\",\"slop\":0,\"zero_terms_query\":\"NONE\",\"boost\":1.0}}},{\"match_phrase\":{\"delFlag\":{\"query\":\"0\",\"slop\":0,\"zero_terms_query\":\"NONE\",\"boost\":1.0}}}],\"adjust_pure_negative\":true,\"boost\":1.0}},\"_source\":{\"includes\":[\"pageCout\"],\"excludes\":[\"content_all\"]}}";

    @Test
    public void search(){
        String checkInNo="08695081001038254100";
        String body = TEMPLETE.replace("${check_in_no}",checkInNo);
        String url = URL.replace("${esIndex}", "");

        HttpResponse response = HttpRequest
                .post(URL)
                .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                .body(body)
                .execute();
        JSONObject jsonObject = JSON.parseObject(response.body());
        System.out.println(jsonObject.getObject("hits", JSONObject.class).getJSONObject("total").get("value"));
    }

    @Test
    public void testdata(){
        List<String> fileLines = FileUtil.readLines("D:\\IdeaProjects\\my_projects\\walle\\walle-study\\src\\main\\resources\\data\\esdata\\esdata.txt", "UTF-8");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fileLines.size(); i++){
            System.out.println("开始处理第" + (i+1)+ "条数据，总共"+fileLines.size()+"条");
            String line = fileLines.get(i);
            String[] items = line.split(",");

            String checkInNo=items[3];
            String body = TEMPLETE.replace("${check_in_no}",checkInNo);
            String url = URL.replace("${esIndex}", items[1]);

            HttpResponse response = HttpRequest
                    .post(url)
                    .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                    .body(body)
                    .execute();
            JSONObject jsonObject = JSON.parseObject(response.body());
            int count = jsonObject.getObject("hits", JSONObject.class).getJSONObject("total").getIntValue("value");
            System.out.print(("\t"+items[0]+ ","+checkInNo +"," + items[2] +",mysql=" + Integer.valueOf(items[4]) +",es=" +count + "\n"));
            if (Integer.valueOf(items[4]) == 0 || count != Integer.valueOf(items[4])) {
                sb.append(items[0]+ ","+checkInNo +"," + items[2] +",mysql=" + Integer.valueOf(items[4]) +",es=" +count + "\n");
            }
        }

        FileUtil.writeString(sb.toString(), "D:\\IdeaProjects\\my_projects\\walle\\walle-study\\src\\main\\resources\\data\\esdata\\esdata_result.txt", "UTF-8");
    }


    @Test
    public void testPageCount(){
        List<String> fileLines = FileUtil.readLines("D:\\IdeaProjects\\my_projects\\walle\\walle-study\\src\\main\\resources\\data\\esdata\\esdata_page.txt", "UTF-8");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fileLines.size(); i++){
            System.out.println("开始处理第" + (i+1)+ "条数据，总共"+fileLines.size()+"条");
            String line = fileLines.get(i);
            String[] items = line.split(",");

            String ossFilePath=items[2];
            String body = TEMPLETE_OSSFILEPATH.replace("${ossFilePath}",ossFilePath);
            String url = URL.replace("${esIndex}", items[1]);

            HttpResponse response = HttpRequest
                    .post(url)
                    .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                    .body(body)
                    .execute();
            JSONObject jsonObject = JSON.parseObject(response.body());

            Integer dbPage = "NULL".equals(items[3])? 0: Integer.valueOf(items[3]);
            if (jsonObject
                    .getObject("hits", JSONObject.class)
                    .getJSONArray("hits") == null || jsonObject
                    .getObject("hits", JSONObject.class)
                    .getJSONArray("hits").size() == 0) {
                sb.append(items[0]+ ","+ossFilePath +"," + items[2] +",mysql=" + dbPage +",es=" + "NOT FOUNT" + "\n");
                continue;
            }
            int count = jsonObject
                    .getObject("hits", JSONObject.class)
                    .getJSONArray("hits").getJSONObject(0)
                    .getObject("_source", JSONObject.class)
                    .getIntValue("pageCout");

            System.out.print(("\t"+items[0]+ ","+ossFilePath +"," + items[2] +",mysql=" + dbPage +",es=" +count + "\n"));
            if (dbPage == 0 || count != dbPage) {
                sb.append(items[0]+ ","+ossFilePath +"," + items[2] +",mysql=" + dbPage +",es=" +count + "\n");
            }
        }

        FileUtil.writeString(sb.toString(), "D:\\IdeaProjects\\my_projects\\walle\\walle-study\\src\\main\\resources\\data\\esdata\\esdata_page_result.txt", "UTF-8");
    }
}
