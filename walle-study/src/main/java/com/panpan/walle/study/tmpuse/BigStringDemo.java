package com.panpan.walle.study.tmpuse;

import cn.hutool.core.util.StrUtil;

import java.util.Stack;

public class BigStringDemo {
    public static void main(String[] args) {
        int maxSize = 200 * 1024 * 1024;

        String content_all="content_all:[{[[]]},{[[]]},{}]";
        StringBuffer sb = new StringBuffer();

        sb.append("AA");
        while (true){
            String s = sb.toString();
            sb.append(s+s);

            if (sb.toString().length() > maxSize)
                break;
        }

        sb.append(content_all);
        String str = removeContentAll(sb.toString());
        long start = System.currentTimeMillis();
        int i = StrUtil.indexOfIgnoreCase(str,"content_all");
        System.out.println("index="+i);
        System.out.println("用时"+(System.currentTimeMillis()-start)+"ms");
        System.out.println(str.length()/1024/1024+"M");
    }

    private static String removeContentAll(String s){
        long start = System.currentTimeMillis();
        if (s == null || s.length() == 0)
            return s;
        int index = StrUtil.indexOfIgnoreCase(s,"content_all");
        System.out.println("remove用时1："+(System.currentTimeMillis()-start)+"ms");
        if (index < 0) return s;
        int begin=0, end =0;
        while (true){
            if (s.charAt(index++) != '[')
                continue;
            break;
        }
        begin = index;

        Stack<Character> stack = new Stack<>();
        stack.push('[');

        while (true){
            char c = s.charAt(index);
            if (c != '[' && c != ']') {
                index++;
                continue;
            }

            if (c =='['){
                stack.push(c);
            } else {
                stack.pop();
                if (stack.isEmpty()){
                    break;
                }
            }
            index++;

        }
        end = index;

        System.out.println(StrUtil.format("begin={}, end={}", begin, end));
//        System.out.println("s1="+s);

        String res =  s.substring(0, begin-1) + ((end > s.length()-1) ? s.substring(end+1) :"");
//        System.out.println("s2="+res);
        System.out.println("remove用时2："+(System.currentTimeMillis()-start)+"ms");
        return res;
    }

}
