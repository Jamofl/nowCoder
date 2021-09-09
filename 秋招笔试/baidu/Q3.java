package 秋招笔试.baidu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Q3 {
    public static long count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        count = 0l;
        dfs(input, new HashSet<Character>(), 0, k);
        System.out.println(count % (1_000_000_000 + 7));
    }

    public static void dfs(String str, HashSet<Character> set, int start, int k){
        if (start == str.length()){
            if (set.size() == k)
                count ++;
            return;
        }

        // add new char
        int size = set.size();
        set.add(str.charAt(start));
        dfs(str, set, start + 1, k);
        if (set.size() == size + 1)
            set.remove(str.charAt(start));

        // not add char
        dfs(str, set, start + 1, k);


    }
}
