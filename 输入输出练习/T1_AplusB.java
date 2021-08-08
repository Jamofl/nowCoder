package 输入输出练习;
import java.util.*;

/*
计算a+b
打开以下链接可以查看正确的代码
1
https://ac.nowcoder.com/acm/contest/5657#question

输入描述:
输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。

输出描述:
输出a + b的结果

输入例子1:
1 5
10 20

输出例子1:
6
30
 */

public class T1_AplusB {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> ans = new LinkedList<>();
        int a;
        int b;
        while (sc.hasNext()){
            a = sc.nextInt();
            b = sc.nextInt();
            ans.add(a + b);
        }

        for (int n : ans)
            System.out.println(n);
    }
}
