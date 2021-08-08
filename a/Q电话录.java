package a;
import java.util.*;


public class Q电话录 {

    public static LinkedList<Integer>[] adjecent;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //sc.nextLine();

        adjecent = new LinkedList[n + 1];
        for (int i = 0; i <= n; i ++)
            adjecent[i] = new LinkedList<>();

        // 建立邻接表
        for (int i = 0; i < m; i ++){
            int input1 = sc.nextInt();
            int input2 = sc.nextInt();
            // sc.nextLine();
            adjecent[input1].add(input2); // 1 -> 2
        }

        int time = sc.nextInt();
        // sc.nextLine();
        int[] result = new int[time];
        for (int j = 0; j < time; j ++){
            int input1 = sc.nextInt();
            int input2 = sc.nextInt();
            //sc.nextLine();
            result[j] = countStep(input1, input2);
        }

        for (int j = 0; j < time; j ++)
            System.out.println(result[j]);
    }

    private static int countStep(int source, int dest){
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        int step = 0;

        while (q.size() != 0){
            int size = q.size();
            step ++;

            while (size > 0){
                int pop = q.poll();
                if (pop == dest)
                    return step - 1;

                for (int node : adjecent[pop])
                    q.offer(node);
                size --;
            }
        }
        return -1;
    }
}
