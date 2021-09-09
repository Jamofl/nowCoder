package 秋招笔试.拼多多2;

import java.util.*;

public class Q44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < t; i ++){
            int n = sc.nextInt();
            int day = sc.nextInt();
            int range = sc.nextInt();
            long target = sc.nextLong();
            int[] laozhi = new int[day];
            int[] position = new int[day];
            for (int j = 0; j < day; j ++){
                laozhi[j] = sc.nextInt();
                position[j] = sc.nextInt();
            }
            ans.add(cal(n, day, range, target, laozhi, position));
        }

        for (int x : ans)
            System.out.println(x);
    }

    public static int cal(int n, int day, int range, long target, int[] laozhi, int[] position){
        long trySum = 0;
        for (int i = 0; i < laozhi.length; i ++)
            trySum += laozhi[i];
        if (trySum < target)
            return -1;


        Map<Integer, Long> map = new HashMap<>(); // 存了每个位置对应的自己 + 左右range位置上的laozhi之和
        Set<Integer> alreadySit = new HashSet<>();
        for (int i = 0; i < n; i ++)
            map.put(i, 0l);

        for (int i = 0; i < day; i ++){
            long curLaozhi = laozhi[i];
            int curPos = position[i];
            alreadySit.add(curPos);
            for (int p = curPos - range; p <= curPos + range; p ++){
                if (p < 0 || p >= n)
                    continue;
                map.put(p, (long)map.get(p) + curLaozhi);
                if (map.get(p) >= target && alreadySit.contains(p))
                    return i;
            }
        }
        return -1;
    }
}
