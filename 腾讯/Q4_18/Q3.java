package 腾讯.Q4_18;


/*
有n个游戏，每个游戏需要在第t[i]个时刻执行，否则就需要扣除对应的w[i]点积分。 求最少扣除的积分数

输入
1 // 一个测试用例
3 // n个正整数
3 1 1 // t[i] 数组，代表每个游戏需要在t[i]时刻被执行
3 6 9 // w[i] 数组，代表每个游戏没被执行，需要扣除的分数

3
3
3 1 1
3 6 9
4
1 2 2 2
3 4 5 6
5
5
1 2 3 4 4
3 4 5 6 7

 */
import java.util.*;
public class Q3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        LinkedList<Integer> ans = new LinkedList<>();

        while (testNum > 0){
            int n = sc.nextInt();
            int[] times = new int[n];
            int[] weights = new int[n];
            int totalScore = 0;
            for (int i = 0; i < n; i ++){
                times[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i ++){
                weights[i] = sc.nextInt();
                totalScore += weights[i];
            }

            int[] cache = new int[1001];
            for (int i = 0; i < n; i ++)
                cache[times[i]] = Math.max(cache[times[i]], weights[i]);

            for (int i = 0; i < cache.length; i ++){
                if (cache[i] != 0)
                    totalScore -= cache[i];
            }

            ans.add(totalScore);
            testNum --;
        }
        for (int a : ans)
            System.out.println(a);
    }
}
