/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.pdd;

import java.util.*;

/**
 * @author jam
 * @version Q1.java, v 0.1 2021年07月25日 19:02 jam
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i ++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            intervals[i][0] = start;
            intervals[i][1] = end;
        }

        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(intervals, cmp);

        boolean flag = false;
        LinkedList<int[]> result = new LinkedList<>();
        int i = 0;
        while (i < intervals.length){
            if (result.isEmpty())
                result.add(intervals[i]);
            else{
                int[] lastInterval = result.removeLast();
                if (intervals[i][1] <= lastInterval[1]){
                    flag = true;
                    break;
                }
                else{
                    result.addLast(new int[] {lastInterval[0], intervals[i][1]});
                }
            }
            i++;
        }
        if (flag == true) {
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }


}