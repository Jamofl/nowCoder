/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.xiapi;

/**
 * @author jam
 * @version Q2.java, v 0.1 2021年07月19日 14:55 jam
 */
public class Q2 {

    public String findMinOverrideSubString(String source, String target) {
        // write code here
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
                    if ((j - i + 1) < shortest){
                        shortest = Math.min(shortest, j - i  + 1);
                        start = i;
                    }
                }
            }
        }
        return source.substring(start, start + shortest);
    }
}