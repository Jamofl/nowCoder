package 秋招笔试.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 给定一个随机字符串 如meituan 生成一个流会不断重复这个字符串，如meituanmeituanmeituan...
 * 现在想要生成一个目标字符串，求生成该目标字符串会浪费流中的多少个字符
 * 输入：
 * meituan
 * uta
 *
 * 输出
 * 10
 * 解释：
 * meituanmeituan  浪费了a前面的10个字符
 */
public class Q3_self {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stream = sc.nextLine().trim();
        String pattern = sc.nextLine().trim();
        Map<Character, Integer> map = new HashMap<>(); // 存储stream中每个字符对应的index
        char[] streamChar = stream.toCharArray();
        char[] patternChar = pattern.toCharArray();

        int n = streamChar.length;
        int m = patternChar.length;
        for (int i = 0; i < n; i ++)
             map.put(streamChar[i], i);

        int ans = 0;
        int index = -1;
        for (int j = 0; j < m; j ++){
            char currentChar = patternChar[j];
            int currentIndex = map.get(currentChar);
            // 可以复用之前的流
            if (currentIndex  > index){
                ans += currentIndex - index - 1;
                index = currentIndex;
            }
            // 不可以复用之前的流
            else{
                ans += n - index - 1 + currentIndex;
                index = currentIndex;
            }
        }
        System.out.println(ans);
    }
}
