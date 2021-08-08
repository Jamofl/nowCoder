/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 虾皮笔试;

/**
 * @author jam
 * @version Q2.java, v 0.1 2021年07月19日 14:55 jam
 * 给定字符串src target
 * 找出src中最短的子串sub 使得target是sub的子序列
 * 若无子序列 返回“” ; 若有不止一个答案，返回最左边那个
 */
public class Q2 {

    public String findMinOverrideSubString(String source, String target) {
        // write code here
        // O(N * L)
        int len = source.length();
        int start = 0;
        int shortest = len + 1;
        for (int i = 0; i < len; i ++){
            if (source.charAt(i) == target.charAt(0)){
                int j = i;
                int t = 0;
                for (; j < len; j ++){
                    if (source.charAt(j) == target.charAt(t))
                        t ++;
                    if (t == target.length())
                        break;
                }
                if (target.length() == t){
                    if ((j - i + 1) < shortest){ // 等于的时候不更新答案 保证了找到的答案一定是最左边那个
                        shortest = Math.min(shortest, j - i  + 1);
                        start = i;
                    }
                }
            }
        }
        return source.substring(start, start + shortest);
    }
}