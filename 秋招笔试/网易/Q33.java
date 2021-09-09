/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.网易;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author jam
 * @version Q3.java, v 0.1 2021年08月21日 16:21 jam
 */
public class Q33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lst = new ArrayList<>();
        int ans = 0;
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            lst.add(num);
        }


        System.out.println(ans);
    }
}