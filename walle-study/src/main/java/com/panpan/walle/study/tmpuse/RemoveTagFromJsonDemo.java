package com.panpan.walle.study.tmpuse;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

public class RemoveTagFromJsonDemo {
    public static void main(String[] args) {
        //String content = FileUtil.readUtf8String("D:\\orcResult_20210902103149591.txt");
        String content = FileUtil.readUtf8String("D:\\orcResult_20210902105354978.txt");
        long start = System.currentTimeMillis();
        int[] pos = splitByTag(content, "content_all");

        System.out.println(StrUtil.format("位置信息{},{}", pos[0], pos[1]));
        System.out.println(StrUtil.format("用时:{}ms", System.currentTimeMillis()-start));
        System.out.println(StrUtil.sub(content, 0, pos[0]) + StrUtil.sub(content, pos[1], content.length()));
    }

    public static int[] splitByTag(String content, String targetTag){

        String[] tags = {"content","originalCheckInNo", "pageCount","confidence","pageconfidence","file_new"};
        int[] ret = new int[]{-1, -1};

        //如果为空
        if (StrUtil.isEmpty(content) || StrUtil.isEmpty(targetTag))
            return ret;

        //未查找到tag
        if (!StrUtil.containsAny(content, targetTag))
            return ret;

        int begin = StrUtil.indexOf( content, StrUtil.format("\"{}\"",targetTag),0, false);
        int end = content.length()-1;
        //找到距离begin之后最近的标签
        for (String tag: tags){
            int index = StrUtil.indexOf( content, StrUtil.format("\"{}\"",tag),begin, false);
            if (index > begin && index < end)
                end = index;
        }

        return new int[]{begin, end};
    }
}
