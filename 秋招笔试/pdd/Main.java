/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.pdd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jam
 * @version Q22.java, v 0.1 2021年07月25日 20:43 jam
 */
public class Main {

    public static int chicken = 0;
    public static int duck = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v1 = new int[n];
        int[] v2 = new int[n];
        for (int i = 0; i < n; i++) {
            v1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v2[i] = sc.nextInt();
        }
        ArrayList<Integer> temp = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < n && j < n){
            while (i < n && helper(temp, v1[i], 1) == 1){
                i ++;
            }
            i ++;
            while (j < n && helper(temp, v2[j], 0) == 1){
                j ++;
            }
            j ++;
        }
        while (i < n){
            helper(temp, v1[i], 1);
            i ++;
        }
        while (j < n){
            helper(temp, v2[j], 0);
            j ++;
        }

        for (int card : temp){
            if (card % 2 == 0)
                duck ++;
            else
                chicken ++;
        }
        System.out.print(chicken + " " + duck);
    }
    private static int helper(ArrayList<Integer> temp, int val, int first){
        int flag = 0;
        for (int i = 0; i < temp.size(); i ++){
            if (temp.get(i)== val){
                if (first == 1)
                    chicken += temp.size() - i + 1;
                else
                    duck += temp.size() - i + 1;
                flag = 1;
                while (temp.get(temp.size() - 1) != val)
                    temp.remove(temp.size() - 1);
            }
        }
        if (flag != 0){
            temp.add(val);
        }
        return flag;

    }

}