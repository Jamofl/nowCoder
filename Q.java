import java.util.*;

public class Q {

    private static class Node{
        int val;
        Set<Node> nei = new HashSet<>();

        public Node(int val){
            this.val = val;
        }
    }

    public static Map<Integer, Node> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        for (int i = 1; i <= n; i ++)
            map.put(i, new Node(i));

        for (int i = 0; i < m; i ++){
            int src = sc.nextInt();
            int dst = sc.nextInt();
            map.get(src).nei.add(map.get(dst));
            map.get(dst).nei.add(map.get(src));
        }

        for (int i = 0; i < q; i ++){
            int src = sc.nextInt();
            int dst = sc.nextInt();
            Node srcNode = map.get(src);
            Node dstNode = map.get(dst);

            srcNode.val = dst;
            dstNode.val = src;
            map.put(src, dstNode);
            map.put(dst, srcNode);
        }

        for (Integer key : map.keySet()){
            System.out.print(map.get(key).nei.size() + " ");
        }
    }
}
/*
add comments
add second comments
add third comments

move forward


5 5 3
1 2
2 3
3 4
4 5
1 4
2 5
1 2
3 4
 */
