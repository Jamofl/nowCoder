package 秋招笔试.meituan;

import java.util.*;

/**
 * 题目：  n 棵数目 从 1 - n 排成一排   第i棵丁香树的芳香值为a[i]
 * 小明从第一棵树走到最后一棵树 当走到第i棵树时，满意度之和为该树之前共有多少种小于当前芳香值的树。求走到第n棵树，总的满意度为多少
 *
 * 填表法  维护一个表格 用于统计到底有多少种树的芳香值小于当前树
 * 每经过一棵树 就把大于这棵树芳香值的地方都 + 1
 */
public class Q1_正确解法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] count = new int[100]; // 用于统计有多少个数比当前的数字小
        int ans = 0;

        ans = getAns(sc, n, count, ans);
        System.out.println(ans);
    }

    private static int getAns(Scanner sc, int n, int[] count, int ans) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i ++){
            int num = sc.nextInt();
            ans = ans +  count[num];
            if (set.contains(num))
                continue;
            else{
                set.add(num);
                for (int j = num + 1; j < 100; j ++){
                    count[j] ++;
                }
            }
        }
        return ans;
    }
}
