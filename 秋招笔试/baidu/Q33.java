package 秋招笔试.baidu;

import java.util.*;

public class Q33 {
    public static long count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        count = 0l;
        dfs(input.toCharArray(), new LinkedList<Character>(), 0, k);
        System.out.println(count % (1_000_000_000 + 7));
    }

    public static void dfs(char[] str, LinkedList<Character> path, int start, int k){
        if (start == str.length){
            System.out.println(path);
            Set<Character> set = new HashSet<>(path);
            if (set.size() == k)
                count ++;
            return;
        }


        // add new char
        path.addLast(str[start]);
        dfs(str, path, start + 1, k);

        // not add char
        path.removeLast();
        dfs(str, path, start + 1, k);


    }
}
