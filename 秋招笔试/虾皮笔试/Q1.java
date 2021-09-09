/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.虾皮笔试;
import java.util.*;

/**
 * @author jam
 * @version Q1.java, v 0.1 2021年07月19日 14:55 jam
 * 假设P点位于坐标轴远点。W S A D 分别表示向上 向下 向左 向右
 * 输入一个字符串序列 如 2W2D  输出最终坐标[2,2]
 * 11W40D -> [11,40]
 */
public class Q1 {
    public static int[] GetEndPoint(String order) {
        // write code here
        if (order == null || order.length() == 0)
            return new int[2];
        order = order.trim().toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('W', 0);
        map.put('D', 0);
        map.put('S', 0);
        int n = order.length();
        char[] arr = order.toCharArray();
        int i = 0;
        while (i < n){
            char c = arr[i];
            if (!Character.isDigit(c)){
                map.put(c, map.get(c) + 1);
                i ++;
            }
            else {
                int time = 0;
                String s = "";
                while (Character.isDigit(arr[i])) {
                    s = s + arr[i];
                    i ++;
                }
                time = Integer.valueOf(s);
                map.put(arr[i], map.get(arr[i]) + time);
                i++;
            }
        }
        int x = map.get('D') - map.get('A');
        int y = map.get('W') - map.get('S');
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(GetEndPoint("3245A234324SDS45D3A")));
    }
}