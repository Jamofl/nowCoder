package 春招实习.huawei;

import java.util.LinkedList;
import java.util.List;
import java.util.*;
/*
给定n个任务，在系统中排队执行，部分任务间存在着依赖关系，若依赖任务未执行，该任务需要加入到队列尾部。
只有任务执行及等待会消耗时间。请计算每个任务的实际执行时间 = 自身执行时间 + 在队列中等待其他任务执行的时间

e.g.1
输入
1,3,4
0->2
输出
8,3,7

e.g.2
输入
1,3,4,5,8,5,3,6
0->2,2->4,2->6
输出
35,3,34,8,16,21,24,30

 */
public class Q2 {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String[] arr = sc.nextLine().split(",");
//        int n = arr.length;
//        int[] nums = new int[n];
//
//
//        String[] dependencyInput = sc.nextLine().split(",");
//        int[] ans = new int[n];
//        List<Integer>[] dependency = new LinkedList[n];
//        for (int i = 0; i < n; i ++){
//            dependency[i] = new LinkedList<>();
//            nums[i] = Integer.parseInt(arr[i]);
//        }
//
//        for (String depen : dependencyInput){
//            int i = depen.charAt(0) - '0';
//            int j = depen.charAt(depen.length() - 1) - '0';
//            dependency[i].add(j);
//        }
//
//        for (int i = 0; i < n; i ++){
//            if (dependency[i].size() == 0)
//                ans[i] = ans[i - 1] + nums[i];
//        }
//
//        for (int i = 0; i < n; i ++){
//            if (dependency[i].size() == 0)
//                ans[i] = ans[i - 1] + nums[i];
//        }
//    }
    // 90% solution

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] missions = line1.split(",");
        int n = missions.length;
        int[] missionTime = new int[n];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            missionTime[i] = Integer.parseInt(missions[i]);
            dq.offer(i);
        }

        String line2 = sc.nextLine();
        String[] depends;
        if (line2.length() == 0) depends = new String[0];
        else depends = line2.split(",");
        int[] time = new int[n];

        Map<Integer, Integer> dependMap = new HashMap<>();
        for (String depend : depends) {
            String[] tmp = depend.split("->");
            int key = Integer.parseInt(tmp[0]);
            if (dependMap.containsKey(key)) {
                dependMap.put(key, Math.max(dependMap.get(key), Integer.parseInt(tmp[1])));
            }
            else dependMap.put(key, Integer.parseInt(tmp[1]));
        }
        Map<Integer, List<Integer>> reverse = new HashMap<>();
        for (Integer integer : dependMap.keySet()) {
            int revKey = dependMap.get(integer);
            if (reverse.containsKey(revKey)) {
                reverse.get(revKey).add(integer);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(integer);
                reverse.put(revKey, tmp);
            }
        }

        int exeTime = 0;
        Set<Integer> trigger = new HashSet<>();
        for (Integer key : dependMap.keySet()) {
            trigger.add(dependMap.get(key));
        }
        while (!dq.isEmpty()) {
            int poll = dq.poll();
            if (dependMap.containsKey(poll)) {
                dq.offer(poll);
            } else {
                if (trigger.contains(poll)) {
                    List<Integer> list = reverse.get(poll);
                    for (Integer integer : list) {
                        dependMap.remove(integer);
                    }
                }
                time[poll] = missionTime[poll] + exeTime;
                exeTime += missionTime[poll];
            }
        }
        for (int i = 0; i < time.length; i++) {
            if (i == time.length - 1) {
                System.out.print(time[i] + "\n");
            }
            else System.out.print(time[i] + ",");
        }
    }
}
