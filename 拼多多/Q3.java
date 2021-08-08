package 拼多多;

import java.util.Scanner;

/*
给定一个字符串,如果构成它的每一种字符出现的次数能够被k整除，定义它为神奇的
现给定一个字符串s，找到字典序小于等于s并且长度和s相等，找到一个神奇字符串T
输入
2    // k的值
abcd // 字符串s

输出
abba
 */
public class Q3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        dfs(str, k, 0);
        if (ans == "a")
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    public static String ans = "a";
    private static void dfs(String str, int k, int start){
        if (check(str, k)){
            if (ans.compareTo(str) < 0){
                ans = str;
                return;
            }
        }
        if (start == str.length())
            return;

        for (int i = start; i < str.length(); i ++){
            char c = str.charAt(i);
            char[] arr = str.toCharArray();
            for (char d = c; d >= 'a'; d --){
                arr[i] = d;
                dfs(String.valueOf(arr), k, i + 1);
                arr[i] = c;
            }
        }
    }

    private static boolean check(String str, int k){
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i ++)
            count[str.charAt(i) - 'a'] ++;
        for (int i = 0; i < 26; i ++){
            if (count[i] != 0){
                if (count[i] % k != 0)
                    return false;
            }
        }
        return true;
    }
}
