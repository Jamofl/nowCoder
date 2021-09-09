/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.京东;

/**
 * @author jam
 * @version Q1.java, v 0.1 2021年08月21日 18:58 jam
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] inputs = new int[n][2];
        for (int i = 0; i < n ; i++){
            inputs[i][0] = sc.nextInt();
            inputs[i][1] = sc.nextInt();
        }
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        };
        Arrays.sort(inputs, cmp);

        int count = 0;
        for (int i = 0; i < n; i ++){
            for (int j = i + 1; j < n; j ++){
                int x1 = inputs[i][0];
                int y1 = inputs[i][1];
                int x2 = inputs[j][0];
                int y2 = inputs[j][1];
                if ((x1 - x2 == y1 - y2) || (x1 - x2 == y2 - y1))
                    count ++;

            }
        }
        System.out.println(count);
    }
}