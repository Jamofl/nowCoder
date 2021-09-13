package 秋招笔试.ByteDacne;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i ++){
            int start = sc.nextInt();
            int duration = sc.nextInt();
            input[i][0] = start;
            input[i][1] = start + duration - 1;
        }
        System.out.println(concurrentDownLoad(input));
    }
    public static int concurrentDownLoad(int[][] intervals) {
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] l1, int[] l2) {
                return l1[0] - l2[0];
            }
        };
        Arrays.sort(intervals, cmp);
        // 小顶堆 用于存储当前结束时间
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);

        int n = intervals.length;
        for (int i = 1; i < n; i ++){
            int[] currentMeeting = intervals[i];
            int currentStartTime = currentMeeting[0];
            int currentEndTime = currentMeeting[1];
            int minFinishedTime = pq.peek();
            // 如果当前开始时间 > 最早结束时间  可复用 更新结束时间即可
            if (currentStartTime > minFinishedTime){
                pq.poll();
                pq.offer(currentEndTime);
            }
            // 如果当前开始时间 < 最早结束时间  不可复用 新加入一个会议
            else{
                pq.offer(currentEndTime);
            }
        }
        // pq的容量即为最终需要的会议室个数
        return pq.size();
    }
}

/*
2
1 2
2 3

4
1 2
2 3
3 5
4 3
 */