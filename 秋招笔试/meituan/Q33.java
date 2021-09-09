package 秋招笔试.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Q33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stream = sc.nextLine().trim();
        String pattern = sc.nextLine().trim();
        Map<Character, TreeSet<Integer>> hashmap = new HashMap<>();
        char[] streamChar = stream.toCharArray();
        char[] patternChar = pattern.toCharArray();

        int n = streamChar.length;
        int m = patternChar.length;
        HelperFun helperFun = new HelperFun(hashmap, streamChar, patternChar, n, m).invoke();
        if (helperFun.is()) return;
        long answer = helperFun.getAnswer();
        System.out.println(answer);
    }

    private static class HelperFun {
        private boolean myResult;
        private Map<Character, TreeSet<Integer>> hashmap;
        private char[] streamChar;
        private char[] patternChar;
        private int n;
        private int m;
        private long answer;

        public HelperFun(Map<Character, TreeSet<Integer>> hashmap, char[] streamChar, char[] patternChar, int n, int m) {
            this.hashmap = hashmap;
            this.streamChar = streamChar;
            this.patternChar = patternChar;
            this.n = n;
            this.m = m;
        }

        boolean is() {
            return myResult;
        }

        public long getAnswer() {
            return answer;
        }

        public HelperFun invoke() {
            for (int j = 0; j < n; j ++){
                if (! hashmap.containsKey(streamChar[j])){
                    TreeSet<Integer> treeSet = new TreeSet<>();
                    hashmap.put(streamChar[j], treeSet);
                }
                hashmap.get(streamChar[j]).add(j);
            }

            int index = -1;
            answer = 0;
            for (int t = 0; t < m; t ++){
                if (!hashmap.containsKey(patternChar[t])){
                    System.out.println(-1);
                    myResult = true;
                    return this;
                }

                TreeSet<Integer> treeSet = hashmap.get(patternChar[t]);
                int temp = treeSet.first();
                if (null == treeSet.ceiling(index)){
                    answer = answer + (n  - index - 1 + temp);
                    index = temp;
                }
                else{
                    int pop = treeSet.ceiling(index);
                    answer = answer - index - 1 + pop;
                    index = pop;
                }
            }
            myResult = false;
            return this;
        }
    }
}
