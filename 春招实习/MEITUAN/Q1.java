package 春招实习.MEITUAN;
/*
优美的字符串定义为  没有任何两个字符相同
求给定字符串的所有子序列中共有多少个优美的字符串
子序列是指原字符串删除0个或多个字符后剩下的字符保持原有的顺序拼接成的字符串
eg 输入aabc  输出12
[]
春招实习.a ab ac abc
春招实习.a ab ac abc
b bc
c
 */
import java.util.HashSet;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        cache = new long[input.length() + 1];
        path = new HashSet<>();

        dfs(input, 0);
        res = res % 20210101;
        System.out.println(res);
    }

    public static HashSet<Character> path;
    public static long res = 0;
    public static long[] cache;


    public static void dfs(String str, int start){
        if (cache[start] != 0){
            res += cache[start];
            return;
        }

        res ++;
        for (int i = start; i < str.length(); i ++){
            char c = str.charAt(i);
            if (! path.contains(c)){
                path.add(c);
                dfs(str, i + 1);
                path.remove(c);
            }
        }
    }
}
