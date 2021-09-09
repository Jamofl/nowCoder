/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.网易;

import java.util.*;

/**
 * @author jam
 * @version Q3.java, v 0.1 2021年08月21日 16:21 jam
 * 一堆小朋友围成一圈准备画画  分纸张给他们
 * 如果这个小孩必旁边的人大  就必须分到更多的纸张 所有孩子至少有一张纸
 * 当且仅当年龄大于相邻小朋友时  才会要求更多纸张
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lst = new ArrayList<>();
        int ans = 0;
        while (sc.hasNextInt()){
            int num = sc.nextInt();
            lst.add(num);
            ans += num;
        }
        System.out.println(ans);
    }
}