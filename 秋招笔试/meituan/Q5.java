package 秋招笔试.meituan;

import java.util.*;

/**
 * 6 2
 * 1 1 1 0 1 0
 * 1 1 2 2 3
 */

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int ans = getAns(sc, n, m);
        System.out.println(ans);
    }

    private static int getAns(Scanner sc, int n, int m) {
        boolean[] stones = new boolean[n + 1];
        // 记录叶子节点的位置
        Set<Integer> leafSet = new HashSet<>();
        List<List<Integer>> adjacentList = new ArrayList<>();
        for (int i = 0; i <= n; i ++)
            adjacentList.add(new LinkedList<>());

        // 记录石头的位置
        for (int i = 1; i <= n; i ++){
            leafSet.add(i);
            if (sc.nextInt() == 1)
                stones[i] = true;
        }

        // 建立临接表  并且在该行中的节点 说明都有邻居 都不是叶子节点
        for (int i = 1; i < n; i ++){
            int src = sc.nextInt();
            adjacentList.get(src).add(i + 1);
            if (leafSet.contains(src))
                leafSet.remove(src);
        }

        Queue<int[]> queue = new LinkedList<>();
        int ans = 0;
        int initLife;
        if (stones[1])
            initLife = m - 1;
        else
            initLife = m;
        queue.add(new int[] {1, initLife}); // [0]代表index索引  [1]代表剩余的生命值

        while (queue.size() != 0){
            int[] pop = queue.poll();
            int curIndex = pop[0];
            int remainingLife = pop[1];
            if (remainingLife < 0)
                continue;
            if (leafSet.contains(curIndex))
                ans ++;
            else{
                for (int neighbor : adjacentList.get(curIndex)){
                    int tempLife;
                    if (stones[neighbor]) // 有石头 生命值减一
                        tempLife = remainingLife - 1;
                    else
                        tempLife = m;     // 无石头 生命值维持
                    queue.add(new int[] {neighbor, tempLife});
                }
            }
        }
        return ans;
    }
}
