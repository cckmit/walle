package com.panpan.walle.study.alg.classic;

import com.panpan.walle.study.alg.common.AlgUtils;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{1,4,5,2,4,6,7};
        bubbleSort(array);
        AlgUtils.printArray(array);
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubbleSort(int[] array){
        if (array == null || array.length == 0)
            return;

        for (int i = 0; i < array.length; i ++){
            for (int j = i+1; j < array.length; j ++){
                if (array[i] > array[j]){
                    AlgUtils.swap(array, i, j);
                }
            }
        }
    }
}
