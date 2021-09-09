package 秋招笔试.蔚来;
/*
求数组中的最大连续和  动态规划
[1 -2 3 4 5]  -> 12
 */
public class Q3 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        // n >= 1
        int n =  array.length;
        int[] dp = new int[n + 1];
        dp[0] = array[0];
        int sum = dp[0];
        for (int i = 1; i < n; i ++){
            if (dp[i - 1] <= 0){
                dp[i] = array[i];
            }
            else{
                dp[i] = dp[i - 1] + array[i];
            }
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(FindGreatestSumOfSubArray(new int[]{-8, -5}));
    }
}
