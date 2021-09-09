/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.pdd;
import java.util.*;

/**
 * @author jam
 * @version Q3.java, v 0.1 2021年07月25日 19:32 jam
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[n];
        for (int i = 0; i < n; i ++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int Q = sc.nextInt();
            if (check(A,B,C,Q))
                ans[i] = 1;
            else
                ans[i] = 0;
        }

        for (int a : ans) { System.out.println(a); }
    }

    private static boolean check(int A, int B, int C, int target){
        Set<Integer> set= new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(A);

        while (queue.size() != 0){
            int m = queue.size();
            while (m > 0){
                int pop = queue.poll();
                int n1 = pop + B;
                int n2 = pop * C;
                if (!set.contains(n1)){
                    set.add(n1);
                    queue.offer(n1);
                }
                if (!set.contains(n2)){
                    set.add(n2);
                    queue.offer(n2);
                }
                m --;
            }
            if (set.contains(target))
                return true;
            else if (Collections.min(set) > target)
                return false;
            set.clear();
        }
        return false;
    }
}
/*
1
2 3 2 10
 */