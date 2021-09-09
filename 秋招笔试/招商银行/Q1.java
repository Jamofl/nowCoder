/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.招商银行;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jam
 * @version Q1.java, v 0.1 2021年08月08日 19:40 jam
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ans = new ArrayList<>();
        int t = sc.nextInt();
        for (int i = 0; i < t; i ++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][m];
            for (int j = 0; j < n; j ++){
                for (int k = 0; k < m; k ++){
                    matrix[j][k] = sc.nextInt();
                }
            }
            if (check(matrix)){
                ans.add("Yes");
            }
            else{
                ans.add("No");
            }
        }
        for (String temp : ans){
            System.out.println(temp);
        }
    }

    public static boolean check(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j ++){
                if (i + 1 < n && j + 1 < m){
                    if (matrix[i][j] != matrix[i + 1][j + 1])
                        return false;
                }
            }
        }
        return true;
    }
}