package 春招实习.腾讯;
/*
现在有n个砝码，每个砝码的重量用一个数组weights[]表示
天平的左盘可以放任意多个重量为m的物品（至少放一个），希望在天平的右边放最少的砝码使得天平平衡。
如果可以做到输出砝码的个数，不能则输出-1.
输入样例
e.g. 1
1           // 一组用例
5 6         // n为5  m为6
1 2 3 4 12  // 砝码weights数组

e.g. 2
2            // 两组用例
1 3          // n为1  m为3
2            // 砝码weights为2
5 6
1 2 3 4 12
 */

import java.util.LinkedList;
import java.util.*;

public class Q5 {


    // dfs回溯 超时
    public static int ans = Integer.MAX_VALUE;
    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> lst = new LinkedList<>();
        int t = sc.nextInt();

        for (int k = 0; k < t; k ++){
            ans = Integer.MAX_VALUE;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] weights = new int[n];
            boolean[] used = new boolean[n];
            Set<Integer> remains = new HashSet<>();

            int sum = 0;
            for (int j = 0; j < n; j ++){
                weights[j] = sc.nextInt();
                sum += weights[j];
                remains.add(weights[j]);
            }
            sc.nextLine();

            int time = 1;
            while (time * m < sum){
                if (dfs(m * time, weights, used, remains, 0))
                    break;
                time ++;
            }

            if (ans == Integer.MAX_VALUE)
                lst.add(-1);
            else
                lst.add(ans);
        }

        for (int n : lst)
            System.out.println(n);

    }
    /*
    1
    10 6
    1 2 3 4 5 6 7 8 9 10
     */

    public static void dfs2(int m, int[] weights, Set<Integer> remains, int count){
        if (remains.contains(m)){
            ans = Math.min(ans, count + 1);
            return;
        }

        else if (m == 0){
            ans = Math.min(ans, count);
            return ;
        }

        else{
//            for (int i = 0; i < weights.length; i ++){
            for (int num : new HashSet<Integer>(remains)){
                remains.remove(num);
                dfs2(m - num, weights, remains, count + 1);
                remains.add(num);

            }
        }
    }


    public static boolean dfs(int m, int[] weights, boolean[] used,Set<Integer> remains, int count) {
        if (remains.contains(m)) {
            ans = Math.min(ans, count + 1);
            return true;
        }
        if (m == 0) {
            ans = Math.min(ans, count);
            return true;
        } else {
            for (int i = weights.length - 1; i >= 0; i--) {
                if (!used[i] && m >= weights[i]) {
                    used[i] = true;
                    remains.remove(weights[i]);
                    if (dfs(m - weights[i], weights, used, remains, count + 1))
                        break;
                    used[i] = false;
                    remains.add(weights[i]);
                }
            }
        }
        return true;
    }
}
