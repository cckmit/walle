package com.panpan.walle.study.alg.others;

import java.util.*;

/**
 * 高阶数独问题
 */
public class Sudo {
    public static void sudo_9(int[][] matrix){
        List<List<Integer>> candList = new ArrayList<>();
        //初始化候选词为全量
        for (int i = 0; i < 9; i++){
            candList.add(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9)));
        }

        //获取可用的候选词
        for (int i = 0; i < 9; i++){
            int r = i / 3;
            int c = i % 3;
            for (int col = c * 3; col < (c+1)*3; col++){
                for (int row = r * 3; row < (r+1)*3; row++){
                    if (matrix[row][col] > 0){
                        candList.get(i).remove(matrix[row][col]);
                    }
                }
            }
        }

        int[][] bigRow0 = getAvailableBigRow(matrix, 0);
        int[][] bigRow1 = getAvailableBigRow(matrix, 1);
        int[][] bigRow2 = getAvailableBigRow(matrix, 2);

    }

    private static int[][] getAvailableBigRow(int[][] matrix, int i) {
        int[][] bigCol0 = getAvailableBigCol(matrix, 0);
        int[][] bigCol1 = getAvailableBigCol(matrix, 1);
        int[][] bigCol2 = getAvailableBigCol(matrix, 2);

        return null;

    }

    private static int[][] getAvailableBigCol(int[][] matrix, int i) {
        return null;
    }


    private static boolean isOk(int[][] matrix) {
        return false;
    }

}
