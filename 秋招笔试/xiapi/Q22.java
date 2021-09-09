/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.xiapi;

/**
 * @author jam
 * @version Q22.java, v 0.1 2021年07月19日 16:42 jam
 */
public class Q22 {
    public String findMinOverrideSubString(String source, String target) {
        // write code here
        int l = 0;
        int r = 0;
        int n = source.length();
        int minLen = n + 1;
        int begin = 0;
        for (int i = 0; i < n; i ++){
            if (source.charAt(i) == target.charAt(0)){
                int k = 0;
                int j = i;
                for (; j < n; j ++){
                    if (source.charAt(j) == target.charAt(k))
                        k ++;
                    if (k == target.length())
                        break;
                }
                if (k == target.length()){
                    if (minLen > (j - i + 1)){
                        minLen = Math.min(minLen, j - i  + 1);
                        begin = i;
                    }
                }
            }

        }
        return source.substring(begin, begin + minLen);
    }
}