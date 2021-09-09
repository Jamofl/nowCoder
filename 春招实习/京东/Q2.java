package 春招实习.京东;

import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] scores = new int[num];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num; i ++){
            scores[i] = sc.nextInt();
            map.put(scores[i], map.getOrDefault(scores[i], 0) + 1);
        }

        int same = Integer.MIN_VALUE;
        int temp = -1;
        for (Map.Entry entry : map.entrySet()){
            if (same < (int) entry.getValue()){
                same = (int) entry.getValue();
                temp = (int) entry.getKey();
            }
        }
        int ans = same - 1;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < scores.length; i ++){
            if (scores[i] != temp){
                while  (! stack.isEmpty()){
                    if (stack.peek() == scores[i])
                        ans ++;
                    stack.pop();
                }
                stack.push(scores[i]);
            }
        }
        System.out.println(ans);

    }
}
