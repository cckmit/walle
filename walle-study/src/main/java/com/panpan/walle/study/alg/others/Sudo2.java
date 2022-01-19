package com.panpan.walle.study.alg.others;


import java.text.MessageFormat;
import java.util.*;

/**
 * 3 * 3 * 3数独问题求解
 */
public class Sudo2 {
    public static class Context{
        List<Set<Character>> rowSetList;
        List<Set<Character>> colSetList;
        List<Set<Character>> blockCandList;

        public Context(){
            rowSetList = new ArrayList<>();
            colSetList = new ArrayList<>();
            blockCandList = new ArrayList<>();
            for (int i = 0; i < 9; i++){
                rowSetList.add(new HashSet<>());
                colSetList.add(new HashSet<>());
                blockCandList.add(new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9')));
            }
        }
    }

    public  void sudo(char[][] m,  char[][] res, Context context){
        initContext(m, context);
        f(m, 0, 0, res, context);
    }

    private  void f(char[][] m, int row, int col, char[][] res, Context context){
        if (col == m.length){
            col = 0;
            row++;
        }

        if (row == m[0].length){
            if (!checkMatrix(m)){
                return;
            }
            copyMatrix(m, res);
            return;
        }

        char old = m[row][col];
        //如果该位置已经有值了，不需要进行填写
        if (old != '.') {
            f(m, row, col + 1, res, context);
        //该位置需要填写
        } else {
            Set<Character> availNum = new HashSet<>(context.blockCandList.get(row / 3 * 3 + col / 3));
            availNum.removeAll(context.rowSetList.get(row));
            availNum.removeAll(context.colSetList.get(col));


            int finalRow = row;
            int finalCol = col;

            availNum.forEach(e->{
                //更新上下文信息
                m[finalRow][finalCol] = e;
                context.rowSetList.get(finalRow).add(e);
                context.colSetList.get(finalCol).add(e);
                context.blockCandList.get(finalRow /3*3+ finalCol /3).remove(e);

                f(m, finalRow, finalCol +1, res, context);

                //恢复上下文信息
                m[finalRow][finalCol] = old;
                context.rowSetList.get(finalRow).remove(e);
                context.colSetList.get(finalCol).remove(e);
                context.blockCandList.get(finalRow /3*3+ finalCol/3).add(e);
            });
        }
    }

    private void copyMatrix(char[][] from, char[][] to){
        for (int i = 0; i != from.length; i++) {
            for (int j = 0; j != from[0].length; j++) {
                to[i][j] = from[i][j];
            }
        }
    }

    private void printMatrix(char[][] matrix) {
        if (matrix == null)
            return;
        for (int i = 0; i != matrix.length; i++) {
            if (i == 3 || i == 6) System.out.println();
            for (int j = 0; j != matrix[0].length; j++) {
                if (j == 3 || j == 6) System.out.print("  ");
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean checkMatrix(char[][] m) {
        for (int col =0; col < 9; col++){
            Set<Character> set = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
            for (int row = 0; row < 9; row++){
                set.remove(m[row][col]);
            }
            if (!set.isEmpty())
                return false;
        }

        return true;
    }

    /**
     * 初始化上下文
     *
     * @param m
     */
    private void initContext(char[][] m, Context context){
        int ROWS = m.length;
        int COLS = m[0].length;

        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                char mValue = m[r][c];
                if (mValue > 0){
                    context.rowSetList.get(r).add(mValue);
                    context.colSetList.get(c).add(mValue);
                    context.blockCandList.get(r/3*3+c/3).remove(mValue);
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] m4 = {
                {'.','.','2',  '.','9','5',  '.','.','.'},
                {'8','.','.',  '7','3','.',  '.','.','.'},
                {'.','.','.',  '4','2','.',  '1','3','.'},

                {'4','.','.',  '.','.','.',  '7','.','9'},
                {'.','.','.',  '3','.','.',  '.','.','.'},
                {'1','.','6',  '.','.','.',  '.','4','.'},

                {'.','.','.',  '.','.','4',  '2','.','.'},
                {'.','.','9',  '.','1','.',  '.','.','.'},
                {'7','.','5',  '.','.','.',  '.','.','6'}};
        char[][] res = new char[9][9];
        Context context = new Context();

        Sudo2 solution = new Sudo2();
        solution.sudo(m4, res, context);

        solution.printMatrix(res);
    }
}
