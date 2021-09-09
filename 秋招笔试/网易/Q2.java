/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.网易;
/**
 * @author jam
 * @version Q2.java, v 0.1 2021年08月21日 15:00 jam
 * 字母从a-z
 * S1 = 'a'
 * S2 = 'abz'
 * S3 = 'abzcayz'
 * ...
 *
 * 规则为Si = Si - 1  + Li + reverseInvert(Si - 1)
 * reverse表示翻转
 * invert表示a -> z, b -> y, c -> x
 */
public class Q2 {
    public char findKthBit (int n, int k) {
        // write code here
        String string1 = "a";
        String string2 = "";
        for (int i = 2; i <= n; i ++){
            string2 = string1 + (char)('a' + i - 1) + reverseAndInvert(string1);
            string1 = string2;
        }
        return string1.charAt(k - 1);
    }

    public String reverseAndInvert(String str){
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i ++){
            int pos = 26 - (arr[i] - 'a') - 1;
            arr[i] = (char)('a' + pos);
        }
        return new StringBuilder(new String(arr)).reverse().toString();
    }
}