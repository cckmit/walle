import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ESTest {
    public static void main(String[] args) {

        String URL = "http://172.16.24.85:9200/sam_index_registration_prod/_doc/_search?from=0&size=10000";
        String body = "\n" +
                "{\n" +
                "\t\"size\": 10000,\n" +
                "\t\"query\": {\n" +
                "\t\t\"bool\": {\n" +
                "\t\t\t\"must\": [{\n" +
                "\t\t\t\t\"match_phrase\": {\n" +
                "\t\t\t\t\t\"orgName\": {\n" +
                "\t\t\t\t\t\t\"query\": \"瑞康医药集团股份有限公司\",\n" +
                "\t\t\t\t\t\t\"slop\": 0,\n" +
                "\t\t\t\t\t\t\"zero_terms_query\": \"NONE\",\n" +
                "\t\t\t\t\t\t\"boost\": 1.0\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"nested\": {\n" +
                "\t\t\t\t\t\"query\": {\n" +
                "\t\t\t\t\t\t\"bool\": {\n" +
                "\t\t\t\t\t\t\t\"must\": [{\n" +
                "\t\t\t\t\t\t\t\t\"match_phrase\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"filelist.delFlag\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"query\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"slop\": 0,\n" +
                "\t\t\t\t\t\t\t\t\t\t\"zero_terms_query\": \"NONE\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"boost\": 1.0\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t}],\n" +
                "\t\t\t\t\t\t\t\"adjust_pure_negative\": true,\n" +
                "\t\t\t\t\t\t\t\"boost\": 1.0\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"path\": \"filelist\",\n" +
                "\t\t\t\t\t\"ignore_unmapped\": false,\n" +
                "\t\t\t\t\t\"score_mode\": \"none\",\n" +
                "\t\t\t\t\t\"boost\": 1.0,\n" +
                "\t\t\t\t\t\"inner_hits\": {\n" +
                "\t\t\t\t\t\t\"ignore_unmapped\": false,\n" +
                "\t\t\t\t\t\t\"from\": 0,\n" +
                "\t\t\t\t\t\t\"size\": 100,\n" +
                "\t\t\t\t\t\t\"version\": false,\n" +
                "\t\t\t\t\t\t\"seq_no_primary_term\": false,\n" +
                "\t\t\t\t\t\t\"explain\": false,\n" +
                "\t\t\t\t\t\t\"track_scores\": false,\n" +
                "\t\t\t\t\t\t\"_source\": {\n" +
                "\t\t\t\t\t\t\t\"includes\": [\"filelist.ossFileUrls\", \"filelist.filename\", \"filelist.pageCout\", \"filelist.confidence\"],\n" +
                "\t\t\t\t\t\t\t\"excludes\": []\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}],\n" +
                "\t\t\t\"adjust_pure_negative\": true,\n" +
                "\t\t\t\"boost\": 1.0\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"_source\": {\n" +
                "\t\t\"includes\": [],\n" +
                "\t\t\"excludes\": [\"filelist.content\",\"filelist.content_all\"]\n" +
                "\t}\n" +
                "}";

        HttpResponse response = HttpRequest
                .post(URL)
                .header(Header.CONTENT_TYPE, ContentType.JSON.getValue())
                .body(body)
                .execute();

        JSONObject jsonObject = JSON.parseObject(response.body());
        JSONArray jsonArray = jsonObject.getObject("hits", JSONObject.class).getJSONArray("hits");

        Map<String, String> esMap = new HashMap<>();
        for (int i=0; i < jsonArray.size(); i++){
            JSONObject item= ((JSONObject) jsonArray.get(i)).getJSONObject("_source");
            String checkInNo = item.getString("checkInNo");
            JSONArray fileList = item.getJSONArray("filelist");
            int fileCount = 0;
            for (int j =0; j < fileList.size();j++){
                JSONObject eachFile = jsonArray.getJSONObject(j);
                System.out.println(eachFile.getString("ossFileUrls"));
                if (1 == eachFile.getIntValue("delFlag")){
                    continue;
                }
                fileCount++;
            }

            esMap.put(checkInNo, fileCount+"");
        }

        List<String> fileLines = FileUtil.readLines("D:\\IdeaProjects\\my_projects\\walle\\walle-start\\src\\main\\java\\com\\panpan\\walle\\start\\data.txt", "UTF-8");
        Map<String, String> fileMap = new HashMap<>();
        for (String line: fileLines){
            List<String> items = StrUtil.split(line, ",");
            fileMap.put(items.get(0), items.get(1));
        }

        Map<String, String> result = new HashMap<>();
        fileMap
            .entrySet()
            .stream()
            .forEach(x->{if (!esMap.containsKey(x.getKey())
                || !StrUtil.equals(fileMap.get(x.getKey()), esMap.get(x.getKey()))){
                result.put(x.getKey(), fileMap.get(x.getKey()) + "," + esMap.get(x.getKey()));
            }});

        System.out.println(result.size());
        for (Map.Entry entry: result.entrySet()){
            System.out.println(entry.getKey() +","+ entry.getValue());
        }
    }

}
