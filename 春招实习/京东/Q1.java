package 春招实习.京东;

import java.util.*;

public class Q1 {

    private static class Node{
        public int x;
        public int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object that) {
            if (this.getClass() != that.getClass())
                return false;
            Node t = (Node) (that);
            return (this.x == t.x) && (this.y == t.y);
        }

        @Override
        public int hashCode() {
            return this.x * 7 + this.y;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> lst = new ArrayList<>(n);
        for (int i = 0; i < n ; i ++){
            int[] temp = new int[2];
            temp[0] = sc.nextInt();
            temp[1] = sc.nextInt();
            lst.add(Arrays.copyOf(temp, 2));
        }

        Map<Node, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i ++){
            for (int j = i + 1; j < n; j ++){
                int a1 = lst.get(i)[0];
                int b1 = lst.get(i)[1];
                int a2 = lst.get(j)[0];
                int b2 = lst.get(j)[1];
                if (a1 != a2) // 斜率不相等
                {
                    if ((b2 - b1) % (a1 - a2) != 0 || (a1 * b2 - a2 * b1) % (a1 - a2) != 0)
                        continue;
                    double x = (double)(b2 - b1) / (a1 - a2);
                    double y = (double)(a1 * b2 - a2 * b1) / (a1 - a2);
//                    if (Math.floor(x) != Math.ceil(x) || Math.floor(y) != Math.ceil(y))
//                        continue;
                    Node node = new Node((int) x , (int)y);
                    map.put(node, map.getOrDefault(node, 0) + 1);
                }
            }
        }

        int[] ans = new int[n + 1];
        for (Map.Entry<Node, Integer> entry : map.entrySet()){
            int count = entry.getValue();
            ans[count] ++;
        }

        for (int j = 1; j <= n; j ++)
            System.out.print(ans[j] + " ");
    }



}
