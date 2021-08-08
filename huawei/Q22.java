package huawei;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Q22 {

    private static class Node {
        int index;
        int time;
        int needTime = 0;

        public Node(int index, int time){
            this.index = index;
            this.time = time;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int n = str.length;
        Node[] time = new Node[n];
        for (int i = 0 ; i < n; i ++){
            time[i] = new Node(i, Integer.valueOf(str[i]));
        }

        String[] dependsStr = sc.nextLine().split(",");
        int[][] depends = new int[n][n];

        for (int i = 0; i < dependsStr.length; i ++){
            String[] deps = dependsStr[i].split("->");
            depends[Integer.valueOf(deps[0])][Integer.valueOf(deps[1])] = 1;
        }

        LinkedList<Node> ans = new LinkedList<>();

        for (int i = 0; i < time.length; i ++)
            ans.add(time[i]);

        for (int i = 0; i < time.length; i ++){
            int currI = time[i].index;
            for (int j = 0; j < depends.length; j ++){
                 if (depends[currI][j] == 1 && j > currI){
                     ans.remove(time[i]);
                     ans.addLast(time[i]);
                 }
            }
        }

        int count = 0;
        for (int i = 0; i < ans.size(); i ++) {
            int cost = ans.get(i).time;
            count += cost;
            ans.get(i).needTime = count;
        }

        Collections.sort(ans, new Comparator<Node>() {
            @Override
            public int compare(Node p1, Node p2) {
                return p1.index - p2.index ;
            }
        });

        for (int i = 0; i < ans.size() - 1; i ++)
            System.out.println(ans.get(i).needTime + ",");

        System.out.println(ans.get(ans.size() - 1).needTime);
    }
}
