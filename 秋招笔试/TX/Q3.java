package 秋招笔试.TX;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++)
            arr[i] = s.charAt(i) - '0';
        System.out.println(helper(arr));
//        int[] dp = new int[]{'0','1','0','1','0','1'};
//        System.out.println(helper(dp));
    }

    public static int helper(int[] arr){
        int n = arr.length;
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;

        int[] dp = new int[n + 1]; //（在可以删除部分前面的元素的情况下） 截止到位置[i]可以达到的累计最大价值
        dp[1] = 1;
        int[] val = new int[n + 1]; // （在可以删除部分前面的元素的情况下）当前这一位置可以达到的最大价值
        val[1] = 1;
        int res = 0 ;
        for (int i = 2; i <= n; i ++){
            int temp = 0;
            for (int j = 1; j < i; j ++){
                if (arr[i - 1] == arr[j - 1])
                    temp = val[j] + 1;
                else
                    temp = 1;

                if (dp[i] < dp[j] + temp){
                    val[i] = temp;
                    dp[i] = dp[j] + val[i];
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
