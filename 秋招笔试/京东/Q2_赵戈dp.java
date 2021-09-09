package 秋招笔试.京东;

import java.util.*;

/**
 *
 */

public class Q2_赵戈dp {
    public static int helper(int[][] matrix) {
        if (matrix[0][0] == 2) {
            return -1;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // 初始化dp数组
        for (int k = 1; k < col; k++) {
            if (matrix[0][k] == 2) {
                break;
            } else {
                dp[k] = dp[k - 1] + cost(matrix[0][k]);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 2) {
                    dp[j] = Integer.MAX_VALUE;
                }
                else if (j > 0) {
                    if (dp[j] == Integer.MAX_VALUE && dp[j - 1] == Integer.MAX_VALUE) {
                        continue;
                    }
                    else {
                        dp[j] = Math.min(dp[j - 1], dp[j]) + cost(matrix[i][j]);
                    }
                }
                else {
                    dp[j] = dp[j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (dp[j] + cost(matrix[i][j]));
                }
            }
        }
        return dp[col - 1] == Integer.MAX_VALUE ? -1 : dp[col - 1];
    }

    public static int cost(int status) {
        if (status == 0) {
            return 2;
        } else {
            return 1;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,1,1,1,0}, {0,1,0,1,0}, {1,1,2,1,1}, {0,2,0,0,1}};
        System.out.println(helper(matrix));
    }
}
