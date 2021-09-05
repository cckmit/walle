package com.panpan.walle.study.anquan;

import cn.hutool.core.math.MathUtil;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 生成密码工具
 */
public class PasswdGenetor {

    public static void main(String[] args) {
        List<String> passwds = getPasswd_v2PlusPrefix();
        for (String s: passwds){
            System.out.println(s);
        }
        System.out.println(StrUtil.format("passwds size:{}", passwds.size()));
    }

    private static List<String> getPasswd_v2PlusPrefix() {
        List<String> prefixs = getPasswdPrefix();
        List<String> passwds = getPasswd_v2();

        List<String> combiles = new ArrayList<>();
        for (String prefix: prefixs){
            for(String pass: passwds){
                combiles.add(StrUtil.format("{}{}",prefix, pass));
            }
        }

        return combiles;
    }

    /**
     * 获取可能的密码表
     * 基于键盘数字的连续输入
     * - 考虑总共按4次和6次按键
     *
     * - 考虑正向连续输入4个，1）先小写，后大写 2)先大写，后小写
     * - 考虑正向连续输入6个，1）先小写，后大写 2)先大写，后小写
     * @return
     */
    private static List<String> getPasswd_v2(){
        List<String> possiblePasswds = new ArrayList<>();

        //不按shift的数字列表
        String digitWithoutShift = "`1234567890";
        //按shift的数字列表
        String digitsWithShift ="~!@#$%^&*()";

        //先不按shift的情况-总共按键4次-第一个按键可能是1-7，对应的下标为[0-6)
        for(int i=0; i < 7;i++){
            String s = "";
            //先小写，再大写的情况
            s = s + digitWithoutShift.charAt(i)
                    + digitWithoutShift.charAt(i+1)
                    + digitsWithShift.charAt(i+2)
                    + digitsWithShift.charAt(i+3)
                    ;
            possiblePasswds.add(s);
            s = "";
            //先大写，再小写的情况
            s = s + digitsWithShift.charAt(i)
                    + digitsWithShift.charAt(i+1)
                    + digitWithoutShift.charAt(i+2)
                    + digitWithoutShift.charAt(i+3)
            ;
            possiblePasswds.add(s);
        }

        //先不按shift的情况-总共按键4次-第一个按键可能是1-7，对应的下标为[0-6)
        for(int i=0; i < 6;i++){
            String s = "";
            //先小写，再大写的情况
            s = s + digitWithoutShift.charAt(i)
                    + digitWithoutShift.charAt(i+1)
                    + digitWithoutShift.charAt(i+2)
                    + digitsWithShift.charAt(i+3)
                    + digitsWithShift.charAt(i+4)
                    + digitsWithShift.charAt(i+5)
            ;
            possiblePasswds.add(s);
            s = "";
            //先大写，再小写的情况
            s = s + digitsWithShift.charAt(i)
                    + digitsWithShift.charAt(i+1)
                    + digitsWithShift.charAt(i+2)
                    + digitWithoutShift.charAt(i+3)
                    + digitWithoutShift.charAt(i+4)
                    + digitWithoutShift.charAt(i+5)
            ;
            possiblePasswds.add(s);
        }

        //其他收集到的密码
        possiblePasswds.add("123");
        possiblePasswds.add("123!");
        possiblePasswds.add("12=");
        possiblePasswds.add("#000");
        possiblePasswds.add("#999");
        possiblePasswds.add("#888");
        possiblePasswds.add("#111");
        possiblePasswds.add("#222");
        possiblePasswds.add("#222");
        possiblePasswds.add("#555");
        possiblePasswds.add("#444");
        possiblePasswds.add("#777");
        possiblePasswds.add("#333");
        possiblePasswds.add("#890");
        possiblePasswds.add("#123");
        possiblePasswds.add("#1234");

        return possiblePasswds;
    }

    /**
     * 数字大写小写的组合
     *
     * @return
     */
    private static List<String> getPasswd_v1(){
        List<String> prefix = Arrays.asList("Juliang", "Admin", "juliang", "admin", "jenkins");
        String[] possibleCharArr1 = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String[] possibleCharArr2 = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")"};

        List<String> ret = new ArrayList<>();
        for(int i =1; i <= 3; i++){
            List<String[]> temp = MathUtil.arrangementSelect(possibleCharArr1, i);
            System.out.println(StrUtil.format("temp size:{}", temp.size()));

            for(String[] strArr: temp){
                StringBuffer sb = new StringBuffer();
                for (String s: strArr){
                    sb.append(s);
                }

                ret.add(sb.toString());
            }
        }

        return ret;
    }
    //可能的用户名
    private static List<String> getLoginName(){
        return Arrays.asList("root", "jenkins", "tech_support", "appadmjjkj");
    }

    //可能的密码前缀
    private static List<String> getPasswdPrefix(){
        return Arrays.asList("root", "Juliang", "Admin", "juliang", "admin", "jenkins","Ju#Liang","Ju@Liang","fusionfin");
    }
}

