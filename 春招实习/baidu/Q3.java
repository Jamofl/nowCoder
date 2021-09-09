package 春招实习.baidu;

import java.util.Scanner;

/*
走楼梯，n个楼梯，每次可以跨1~m步，每一步和之前的两步走的台阶数不能相同，求有多少种不同的走法。
 */
public class Q3 {
    public static long ans = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dfs(n, m, 0, 0);
        System.out.println(ans);
    }

    private static void dfs(int n, int m, int pre1, int pre2){
        if (n == 0){
            ans  = ans + 1;
            return;
        }

        for (int i = 1; i <= m; i ++){
            if (i == pre1 || i == pre2)
                continue;
            else if (n - i < 0)
                continue;
            else{
                dfs(n - i, m, i, pre1);
            }
        }
    }
}
