package com.panpan.walle.study.alg.common;

public class AlgUtils {
    /**
     * 交换数组两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 打印数组对象
     *
     * @param array
     */
    public static void printArray(int[] array){
        if (array == null || array.length == 0){
            return;
        }

        System.out.println("======== array 数据 =========");
        for(int e: array){
            System.out.printf("%d ", e);
        }
    }
    /**
     * 打印数组对象
     *
     * @param array
     */
    public static void printMatrix(int[][] array){
        if (array == null || array.length == 0){
            return;
        }

        for(int[] a: array){
            for(int e: a){
                System.out.printf("%d ", e);
            }
            System.out.println();
        }
    }

    /**
     * 打印链表
     */
    public static void printListNode(ListNode head){
        System.out.println("======== listNode 数据 =========");
        ListNode curr = head;
        while (curr != null){
            System.out.printf("%d ", curr.val);
            curr = curr.next;
        }
    }
}
