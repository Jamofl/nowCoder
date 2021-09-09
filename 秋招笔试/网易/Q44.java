/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.网易;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jam
 * @version Q4.java, v 0.1 2021年08月21日 15:07 jam
 */
public class Q44 {
    public static int   ans = Integer.MAX_VALUE;
    public static int[] Is  = new int[] {-1, 0, 1, 0};
    public static int[] Js  = new int[] {0, 1, 0, -1};

    public int minSailCost(int[][] input) {
        // write code here
        System.out.println(check(input));
        return -1;
    }

    private boolean check(int[][] input){
        int row = input.length;
        int col = input[0].length;
        // 存的是坐标
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (queue.size() != 0) {
            int[] popped = queue.poll();
            if (popped[0] == row - 1 && popped[1] == col - 1) {
                return true;
            }
            for (int k = 0; k <= 3; k++) {
                int newI = popped[0] + Is[k];
                int newJ = popped[1] + Js[k];
                if (newI >= 0 && newI <= input.length - 1 && newJ >= 0 && newJ <= input[0].length - 1){
                    if (input[newI][newJ] != 2) {
                        input[newI][newJ] = 2;
                        queue.offer(new int[] {newI, newJ});
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] input = new int[][] {{1,2}, {2,1}};
        int[][] test2 = new int[][] {{1,1,1,1,0},{0,1,0,1,0},{1,1,2,1,1},{0,2,0,0,1}};
        Q44 q44 = new Q44();
        System.out.println(q44.minSailCost(input));
    }

}