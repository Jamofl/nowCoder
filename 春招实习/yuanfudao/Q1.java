package 春招实习.yuanfudao;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //sc.nextLine();
        boolean[] ans = new boolean[n];

        for (int i = 0; i < n; i ++){
            int m = sc.nextInt();
            int[] nums = new int[m];
            for (int j = 0; j < m; j ++)
                nums[j] = sc.nextInt();

            ans[i] = check(nums);
        }

        for (int i = 0; i < n; i ++){
            if (ans[i])
                System.out.println("Y");
            else
                System.out.println("N");
        }
    }

    private static boolean check(int[] nums){
        int i = 0;

        while (i < nums.length - 1){
            if (nums[i] < nums[i + 1])
                break;
            if (i == nums.length - 2)
                return true;
            i ++;
        }

        if (nums[nums.length - 1] < nums[0])
            return false;

        for (int j = i + 1; j < nums.length - 1; j ++) {
            if (nums[j] < nums[j + 1])
                return false;
        }
        return true;
    }
}
