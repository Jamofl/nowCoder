/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.网易;

import java.util.*;

/**
 * @author jam
 * @version Q4.java, v 0.1 2021年08月21日 15:07 jam
 * 二维网格 0表示水 1表示陆地 2表示障碍物
 * 走路地费用为1
 * 走水路费用为2
 * 计算从起点到终点的最小费用 如不可到达返回-1 （初始位置不计费用）
 *
 */
public class Q4 {
    public static int   ans = Integer.MAX_VALUE;
    public static int[] Is  = new int[] {-1, 0, 1, 0};
    public static int[] Js  = new int[] {0, 1, 0, -1};

    public int minSailCost(int[][] input) {
        // write code here
        int row = input.length;
        int col = input[0].length;
        boolean[][] visit = new boolean[row][col];
        visit[0][0] = true;
        dfs(input, visit,0, 0, row - 1, col - 1, 0);
        if (check(input))
            return ans;
        else
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

    public void dfs(int[][] input, boolean[][] visit, int i, int j, int targetI, int targetJ, int cost) {
        if (i == targetI && j == targetJ) {
            ans = Math.min(ans, cost);
            return;
        }
        if (cost > ans)
            return;
        for (int k = 0; k <= 3; k ++){
            int newI = i + Is[k];
            int newJ = j + Js[k];
            if (newI >= 0 && newI <= input.length - 1 && newJ >= 0 && newJ <= input[0].length - 1 && input[newI][newJ] != 2
            && !visit[newI][newJ]){
                int extraCost = 0;
                if (input[newI][newJ] == 0)
                    extraCost = 2;
                else if (input[newI][newJ] == 1)
                    extraCost = 1;
                int temp = input[newI][newJ];
                input[newI][newJ] = 2;
                visit[newI][newJ] = true;
                dfs(input, visit, newI, newJ, targetI, targetJ, cost + extraCost);
                input[newI][newJ] = temp;
                visit[newI][newJ] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{1,0}, {1,1}};
        int[][] test2 = new int[][] {{1,1,1,1,0},{0,1,0,1,0},{1,1,2,1,1},{0,2,0,0,1}};
        Q4 q4 = new Q4();
        System.out.println(q4.minSailCost(test2));
    }

}