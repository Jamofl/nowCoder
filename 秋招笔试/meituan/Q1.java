package 秋招笔试.meituan;

import java.util.HashSet;
import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i ++){
            input[i] = sc.nextInt();
        }
        int sum = getSum(n, input);
        System.out.println(sum);
    }

    private static int getSum(int n, int[] input) {
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[n];
        for (int i = 0 ; i < n; i ++){
            set.clear();
            for (int j = 0; j < i; j ++){
                if (input[j] < input[i]){
                    set.add(input[j]);
                }
            }
            ans[i] = set.size();
        }

        int sum = 0;
        for (int x : ans){
            sum += x;
        }
        return sum;
    }
}
