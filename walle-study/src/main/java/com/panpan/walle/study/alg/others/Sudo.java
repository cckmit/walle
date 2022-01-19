package com.panpan.walle.study.alg.others;

import com.alibaba.fastjson.JSON;

public class Sudo {
    public static void f(int[][] m){
        int[] cands = {1,2,3,4,5,6,7,8,9};

        g(m, cands, 0);
    }

    private static void g(int[][] m, int[] cands, int i){
        if (i == cands.length){
            System.out.println("cands=" + JSON.toJSONString(cands));
            return;
        }

        for (int j = i; j < cands.length; j++){
            swap(cands, i, j);
            int mValue = m[i/3][i%3];
            if (mValue == 0 || mValue == cands[i]) {
                g(m, cands, i + 1);
            }
            swap(cands, j, i);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1,0,3},
                {0,0,0},
                {7,9,8}};
        f(m);
    }
}
