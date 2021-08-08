package huawei;

import java.util.Scanner;
/*
给定一个矩阵，找出路径和最接近目标t但又小于目标t的路径  每次只可以选择向右或向下两个方向

输入
5 5 30       // n n t
3 5 4 2 3
4 5 3 4 2
4 3 5 3 2
2 53 3 5
5 3 4 4 1

输出
30
 */

public class Q3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int time = sc.nextInt();
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                matrix[i][j] = sc.nextInt();
            }
        }
        result = -1;
        dfs(matrix, 0, 0, time, 0);
        System.out.println(result);
    }

    public static int result;
    private static void dfs(int[][] matrix, int curRow, int curCol, int time, int path){
        if (path > time)
            return;

        if (curRow == matrix.length - 1 && curCol == matrix[0].length - 1 && path + matrix[curRow][curCol] <= time){
            result = Math.max(result, path + matrix[curRow][curCol]);
            return;
        }

        if (curRow + 1 < matrix.length){
            dfs(matrix, curRow + 1, curCol, time, path + matrix[curRow][curCol]);
        }

        if (curCol + 1 < matrix[0].length){
            dfs(matrix, curRow, curCol + 1, time, path + matrix[curRow][curCol]);
        }

    }
}
