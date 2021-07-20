package com.panpan.walle.study.tmpuse;

public class TmpUse {
    public static void main(String[] args) {
        String s = "111";
        new TmpUse().test(s);
        System.out.println(s);
    }

    private void test(String s){
        s = "2222";
    }
}
