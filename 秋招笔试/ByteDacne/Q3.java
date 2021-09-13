package 秋招笔试.ByteDacne;

import java.util.ArrayList;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < t; i ++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            long prod1 = 1, prod2 = 1;
            for (int j = 0; j < n; j ++)
                prod1 = prod1 * sc.nextInt();

            for (int j = 0; j < m; j ++)
                prod2 *= sc.nextInt();

            if (prod1 % prod2 == 0)
                ans.add("yes");
            else
                ans.add("no");
        }
        for (String a : ans)
            System.out.println(a);
    }
}
/*
2
2 5
10 12
2 3 5 2 1
4 5
7 2 5 3
2 4 5 6 1
 */
