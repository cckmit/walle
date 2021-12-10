package com.panpan.walle.study.alg.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 42. 接雨水
 */
public class No0042_Trap {
    public static void main(String[] args) {
        trap(new int[]{0, 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1, 0});
    }

    public static int trap(int[] height) {
        int[][] nearMore = getNearMore(height);
        int[] sumArr = getAccumSum(height);

        int index = 0;
        //丢弃前面无效的数据
        while (index < height.length && height[index] == 0) {
            index++;
        }

        int result = 0;
        for (int i = index; i < height.length;) {
            //右侧比自己高的柱子
            if (nearMore[i][1] > -1) {
                //左侧高度 * 宽度 - 已有的柱子体积
                int tmpSum = (height[i] * (nearMore[i][1] - i) - (sumArr[nearMore[i][1] - 1] - sumArr[i - 1]));
                System.out.println("tmpSum1=" + tmpSum);
                i = nearMore[i][1];
            } else {
                index = i + 1;
                if (index < height.length - 1) {
                    int curMostHeight = 0;
                    while (index < height.length && nearMore[index][0] == i && height[index] > curMostHeight) {
                        curMostHeight = height[index];
                    }

                    int tmpSum = (height[index] * (index - i - 1) - (sumArr[index - 1] - sumArr[i - 1]));
                    i = index;
                    System.out.println("tmpSum2=" + tmpSum);
                }


            }
        }
        return result;
    }

    /**
     * 最近最大（可以重复）
     *
     * @param arr
     * @return
     */
    public static int[][] getNearMore(int[] arr) {
        int[][] res = new int[arr.length][2];
        // List<Integer> -> 放的是位置，同样值的东西，位置压在一起
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) { // i -> arr[i] 进栈
            // 底 -> 顶， 大 -> 小
            while (!stack.isEmpty() && arr[stack.peek().get(0)] < arr[i]) {
                List<Integer> popIs = stack.pop();
                // 取位于下面位置的列表中，最晚加入的那个
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popi : popIs) {
                    res[popi][0] = leftLessIndex;
                    res[popi][1] = i;
                }
            }
            // 相等的、比你小的
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> popIs = stack.pop();
            // 取位于下面位置的列表中，最晚加入的那个
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer popi : popIs) {
                res[popi][0] = leftLessIndex;
                res[popi][1] = -1;
            }
        }
        return res;
    }

    /**
     * 计算累加和
     *
     * @param arr
     * @return
     */
    private static int[] getAccumSum(int[] arr) {
        int[] sumArr = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sumArr[i] = sum;
        }

        return sumArr;
    }
}
