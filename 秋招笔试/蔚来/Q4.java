package 秋招笔试.蔚来;
import java.util.Arrays;
/*
硬币找钱问题
https://leetcode-cn.com/problems/coin-change/
 */
public class Q4 {
    public static int minCoins (int V, int[] coins, int M) {
        // write code here
        int[] dp = new int[V + 1];
        Arrays.fill(dp,  V + 1);
        dp[0] = 0;
        for (int i = 1; i <= V; i ++){
            for (int j = 0; j < coins.length; j ++){
                if (i - coins[j] < 0)
                    continue;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[V] > V ? -1 : dp[V];
    }

    public static void main(String[] args) {
        int[] arr = new int[] {25,10,5};
        System.out.println(minCoins(30, arr, arr.length));
    }
}
