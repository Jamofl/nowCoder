package 华为笔试题.真题3_31;

import java.util.LinkedList;
import java.util.*;

public class Q3_3 {
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
            char c = pattern.charAt(0);
            List<Integer> lst = new LinkedList<>();
            for (int i = 0; i < arr.length(); i ++){
                if (arr.charAt(i) == c)
                    lst.add(i);
            }

            int tempStep = (Math.abs(index - lst.get(0)) == arr.length() - 1) ? 1 :  Math.abs(index - lst.get(0));
            int ans = dfs(arr, pattern.substring(1), lst.get(0), step + tempStep);

            for (int i = 1; i < lst.size(); i ++){
                tempStep = (Math.abs(index - lst.get(i)) == arr.length() - 1) ? 1 :  Math.abs(index - lst.get(i));
                int ans2 = dfs(arr, pattern.substring(1), lst.get(i), step + tempStep);
                ans = Math.min(ans, ans2);
            }

            return ans;


//            int tryRight = 0;
//            int tryLeft = 0;
//            int i = index;
//            while (arr.charAt(i) != pattern.charAt(0)){
//                i ++;
//                tryRight ++;
//                if (i == arr.length())
//                    i = 0;
//            }
//
//            int j = index;
//            while (arr.charAt(j) != pattern.charAt(0)){
//                j --;
//                tryLeft ++;
//                if (j == -1)
//                    j = arr.length() - 1;
//            }
//
//            int ans1 = dfs(arr, pattern.substring(1), i, step + tryRight);
//            int ans2 = dfs(arr, pattern.substring(1), j, step + tryLeft);
//            return Math.min(ans1, ans2);
        }
    }
}
