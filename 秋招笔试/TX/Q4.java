package 秋招笔试.TX;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int ans = helper(num, l, r);
        System.out.println(ans);
    }

    public static int helper(int num, int left, int right){
        List<Integer> lst = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while (!queue.isEmpty()){
            boolean flag = true;

            int size = queue.size();
            lst = new ArrayList<>();
            for (int i = 0; i < size; i ++){
                int pop = queue.poll();
                if (pop > 1){
                    flag = false;
                     queue.add(pop / 2);
                     queue.add(pop % 2);
                     queue.add(pop / 2);
                }
                else{
                    queue.add(pop);
                }
                lst.add(pop);
            }
            if (flag)
                break;

        }
        int sum = getSum(left, right, lst);
        return sum;
    }

    private static int getSum(int left, int right, List<Integer> lst) {
        int ans = 0;
        for (int i = left - 1; i < right; i ++){
            if (1 == lst.get(i))
                ans ++;
        }
        return ans;
    }
}
