package 秋招笔试.ByteDacne;

import java.util.ArrayList;
import java.util.Scanner;

public class Q4 {
    public static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < t; i ++){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j ++)
                nums[j] = sc.nextInt();
            ansList.add(maxLen(nums));
        }
        for (int a : ansList)
            System.out.println(a);
    }

    public static int maxLen(int[] nums){
        dfs(nums, 0, 0 ,0);
        return ans;
    }

    public static void dfs(int[] nums, int index, int sum, int count){
        if (index == nums.length){
            ans = Math.max(count, ans);
            return;
        }

        if (sum + nums[index] >= 0)
            dfs(nums, index + 1, sum + nums[index], count + 1);
        dfs(nums, index + 1, sum, count);
    }
}

/*
2
6
4 -4 1 -3 1 -3
5
1 2 3 4 5
 */