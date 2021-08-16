package com.panpan.walle.study.alg.zcy.study.class01;


import com.panpan.walle.study.alg.common.AlgUtils;

import java.util.Arrays;

public class Code01_SelectionSort {
    public void selectSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        int N = arr.length;

        for (int i =0; i < N; i++){
            int minIndex = i;
            for (int j = i +1; j < N; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            AlgUtils.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {

        Code01_SelectionSort solution = new Code01_SelectionSort();
        for (int i = 0; i < 1000; i++){
            int[] arr1 = AlgUtils.generateRandomArray(1000, 100);
            int[] arr2 = AlgUtils.copyOfArray(arr1);

            solution.selectSort(arr1);
            Arrays.sort(arr2);

            if (!Arrays.equals(arr1, arr2)){
                System.out.println("NG");
                break;
            }
        }
        System.out.println("OK");
    }
}
