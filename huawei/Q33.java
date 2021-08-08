package huawei;

import java.util.Scanner;

public class Q33 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int time = sc.nextInt();

        int[][] matrix = new int[row + 1][col + 1];
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                matrix[i][j] = sc.nextInt();
            }
        }
        result = -1;
        dfs(matrix, row, col, 0, 0, time, matrix[0][0]);
        System.out.println(result);
    }

    public static int result;
    private static void dfs(int[][] matrix, int row, int col, int curRow, int curCol, int time, int path){
        if (path > time)
            return;

        if ((curRow == row - 1) && (curCol == col - 1)){
            result = Math.max(result, path);
            return;
        }

        if ((curRow + 1 <= row - 1) && (curCol <= col - 1)){
            dfs(matrix, row, col,curRow + 1, curCol, time, path + matrix[curRow + 1][curCol]);
        }

        if ((curCol + 1 <= col - 1) && (curRow <= row - 1)){
            dfs(matrix, row, col, curRow, curCol + 1, time, path + matrix[curRow][curCol + 1]);
        }
    }
}
