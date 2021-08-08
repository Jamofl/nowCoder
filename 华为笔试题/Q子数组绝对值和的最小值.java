package 华为笔试题;

import java.util.Arrays;
import java.util.Scanner;

/*
给定一个随机的整数数组（正数负数都有可能），找到两个元素，使得|nums[i] + nums[j]|最小，并返回这两个数及绝对值
如 输入  -1 -3 7 5 11 15
返回 -3 5 2
解释： -3 + 5 = 2, 绝对值最小
 */
public class Q子数组绝对值和的最小值 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i ++)
            nums[i] = Integer.parseInt(arr[i]);
        Arrays.sort(nums);
        minAbs(nums);
    }

    public static void minAbs(int[] nums){
        int i = 0;
        int n = nums.length;
        while (i < n){
            if (nums[i] < 0)
                i ++;
            else
                break;
        }
        if (i == 0){
            System.out.print(nums[0] + " ");
            System.out.print(nums[1] + " ");
            System.out.print(nums[0] + nums[1]);
        }
        else if (i == n - 1){
            System.out.print(nums[n - 2] + " ");
            System.out.print(nums[n - 1] + " ");
            System.out.print(nums[n - 2] + nums[n - 1]);
        }
        else{
            int l = i - 1;
            int r = i;
            int ansL = 0;
            int ansR = 0;
            int ansSum = Integer.MAX_VALUE;
            while (l >= 0 && r <= n - 1){
                if (ansSum > Math.abs(nums[l] + nums[r])){
                    ansSum = nums[l] + nums[r];
                    ansL = l;
                    ansR = r;
                }
                if (nums[l] + nums[r] > 0)
                    l --;
                else if (nums[l] + nums[r] < 0)
                    r ++;
                else
                    break;
            }

            System.out.print(nums[ansL] + " ");
            System.out.print(nums[ansR] + " ");
            System.out.print(ansSum);
        }
    }


}
