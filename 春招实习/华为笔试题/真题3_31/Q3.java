package 春招实习.华为笔试题.真题3_31;

import java.util.Scanner;
/*
给定一个队列，一个字符串，和一个起始下标。移动下标，以最小步数找到该字符串。
游标每次可以向左或者向右移动一步，到最右边时可以向右移动一位到达最左边，到最左边时可以向左移动一位到达最右边。
 */

public class Q3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        String pattern = sc.nextLine();
        int index = sc.nextInt();
        int r = dfs(arr, pattern, index, 0);
        System.out.println(r);
    }

    public static int dfs(String arr, String pattern, int index, int step){
        if (pattern == null || pattern.length() == 0)
            return step;

        else if (arr.charAt(index) == pattern.charAt(0)){
            return dfs(arr, pattern.substring(1), index, step);
        }

        else{
            int tryRight = 0;
            int tryLeft = 0;
            int i = index;
            while (arr.charAt(i) != pattern.charAt(0)){
                i ++;
                tryRight ++;
                if (i == arr.length())
                    i = 0;
            }

            int j = index;
            while (arr.charAt(j) != pattern.charAt(0)){
                j --;
                tryLeft ++;
                if (j == -1)
                    j = arr.length() - 1;
            }

            int ans1 = dfs(arr, pattern.substring(1), i, step + tryRight);
            int ans2 = dfs(arr, pattern.substring(1), j, step + tryLeft);
            return Math.min(ans1, ans2);
        }
    }
}
