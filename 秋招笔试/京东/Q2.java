/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.京东;

import java.util.Scanner;

/**
 * @author jam
 * @version Q2.java, v 0.1 2021年08月21日 18:58 jam
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = sc.next().trim().toCharArray();
        int[] ans = new int[n];
        int sumO = 0;
        int sum1 = 0;
        for (int i = 0; i < n; i ++){
            char c = arr[i];
            if (c == '0')
                sumO ++;
            else
                sum1 ++;
            if (isPrime(sumO) && isPrime(sum1))
                ans[i] = 1;
            else
                ans[i] = 2;
        }
        for (int i = 0; i <= n - 2; i ++){
            System.out.print(ans[i] + " ");
        }
        System.out.print(ans[n - 1]);
    }

    public static boolean isPrime(int n ){
        if (n == 1)
            return true;
        int temp = n - 1;
        for (int i = 2; i <= temp; i ++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
    //public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //    int n = sc.nextInt();
    //    String s = sc.next();
    //
    //    for (int i = 1; i <= n - 1; i++)
    //    {
    //        System.out.print(i);
    //        System.out.print(" ");
    //    }
    //    System.out.print(n);
    //}
}