package 华为笔试题.真题4_14;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
输入
4        // 长度为4
2 3 1 1  // nums[i]表示能走的最远距离

输出
2        // 输出走到终点最少需要几次   1 -> 3, 3 -> 4
 */
public class Q3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++)
            nums[i] = sc.nextInt();


        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i --){
            for (int j = i + 1; j <= i + nums[i]; j ++){
                if (j >= n)
                    break;
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        System.out.println(dp[0]);
    }

}
/*
4
2 3 1 1

6
2 5 1 1 1 1
 */