package 秋招笔试.拼多多2;


import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            ans.add(minStep(p, q));
        }

        for (int x : ans)
            System.out.println(x);
    }

    public static int ans = Integer.MAX_VALUE;

    public static int minStep2(int src, int target) {
        ans = Integer.MAX_VALUE;
        dfs(src, target, 0);
        return ans;
    }

    private static void dfs(int src, int target, int step) {
        if (src == target) {
            ans = Math.min(ans, step);
            return;
        }
        if (src > target) {
            dfs(src - 2, target, step + 1);
            dfs(src - 1, target, step + 1);
        } else {
            dfs(src + 1, target, step + 1);
            dfs(src * 2, target, step + 1);
        }
    }


    public static int minStep(int src, int target) {
        if (src == target)
            return 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        int step = 0;
        while (q.size() != 0) {
            int size = q.size();
            while (size > 0) {
                int pop = q.poll();
                if (pop == target)
                    return step;
                q.offer(pop + 1);
                q.offer(pop * 2);

                q.offer(pop - 2);
                q.offer(pop - 1);
                size--;
            }
            step++;
        }
        return -1;
    }
}
