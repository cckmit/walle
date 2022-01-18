package com.panpan.walle.study.temp;

import com.alibaba.fastjson.JSON;

public class Temp {

    public static void main(String[] args) {
        //int[] arr = new int[]{1,3,5,6,7,8};
        int[] arr = new int[]{2,3,4,5,7,9};
        f(arr, 0);
    }

    public static void f(int[] arr, int i){
        if (i == arr.length - 1){
            if (isOk(arr))
            System.out.println("arr="+ JSON.toJSONString(arr));
        }

        for (int j  = i; j < arr.length; j++){
            swap(arr, i, j);
            f(arr, i+1);
            swap(arr, j, i);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static boolean isOk(int[] arr){
        int s1 = arr[0] + arr[1] + arr[3];
        int s2 = arr[0] + arr[2] + arr[5];
        int s3 = arr[3] + arr[4] + arr[5];

        return (s1 == s2) && (s1 == s3);
    }
}
