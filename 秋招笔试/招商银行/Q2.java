/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.招商银行;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jam
 * @version Q2.java, v 0.1 2021年08月08日 19:58 jam
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i ++)
            A[i] = sc.nextInt();
        for (int i = 0; i < n; i ++)
            B[i] = sc.nextInt();
        Arrays.sort(A);
        Arrays.sort(B);

        int total = 0;
        int win = 0;
        int i = n - 1;
        boolean flag = false;
        while(i >= 0){
            if (A[i] == B[i]){
                i --;
                continue;
            }
            if (A[i] > B[i]){
                win ++;
            }
            total ++;
            if ((((float)win) / total) > 0.5){
                System.out.println(n - i);
                flag = true;
                break;
            }
            i --;
        }
        if (! flag) {
            System.out.println(-1);
        }
    }
}