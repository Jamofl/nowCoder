package 秋招笔试.蔚来;

import java.util.Arrays;
import java.util.Stack;
/*
柱状图中的最大矩形
https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class Q2 {
    public static int countArea(int[] A, int n) {
        // write code here
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i ++){
            while (! stack.isEmpty() && A[stack.peek()] >= A[i]){
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i ++){
            ans = Math.max(ans, (right[i] - left[i] - 1) * A[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,9,4,1};
        int r =  countArea(arr, arr.length);
        System.out.println(r);
    }
}
