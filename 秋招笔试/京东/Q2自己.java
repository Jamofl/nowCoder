package 秋招笔试.京东;

public class Q2自己 {
    public static int minCost(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        if (matrix[0][0] == 2 || matrix[row - 1][col - 1] == 2)
            return -1;

        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int j = 1; j < col; j ++){
            if (matrix[0][j] == 2)
                break;
            else
                dp[0][j] = dp[0][j - 1] + cost(matrix[0][j]);
        }

        for (int i = 1; i < row; i ++){
            for (int j = 0; j < col; j ++){
                // 当前区域不可达 直接置为Integer.MAX_VALUE
                if (matrix[i][j] == 2)
                    continue;
                // 第一列的情况
                else if (j == 0)
                    dp[i][j] = dp[i - 1][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i - 1][j] + cost(matrix[i][j]);
                // 正常case  分两种情况
                else{
                    // 不可达
                    if (dp[i - 1][j] == Integer.MAX_VALUE && dp[i][j - 1] == Integer.MAX_VALUE)
                        continue;
                    // 等于左边和上面方格中较小者 + 当前cost
                    else
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + cost(matrix[i][j]);
                }
            }
        }
        if (dp[row - 1][col - 1] == Integer.MAX_VALUE)
            return -1;
        else
            return dp[row - 1][col - 1];
    }

    public static int cost(int n){
        return n == 1 ? 1 : 2;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,1,1,1,0}, {0,1,0,1,0}, {1,1,2,1,1}, {0,2,0,0,1}};
        System.out.println(minCost(matrix));
    }
}
