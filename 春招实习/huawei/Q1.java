package 春招实习.huawei;
import java.util.*;
/*
许多小朋友 两两为一组 总共可以分为几组
输入
4
A B
B D
C D
D A

输出
1
 */

public class Q1 {
    // 使用并查集
    private static class DisjointSet{

        public Map<String, String> map;
        public int groupNum;
        public DisjointSet(int n){
            groupNum = n;
            map = new HashMap<>();
        }

        public void union(String s, String t){
            String rootS = find(s);
            String rootT = find(t);
            if (rootS.equals(rootT))
                return;
            map.put(rootS, rootT);
            map.put(rootT, "R");
            groupNum --;
        }

        public String find(String s){
            String root = s;
            while (map.getOrDefault(root, "R") != "R"){
                root = map.get(root);
            }

//            String cur = s;
//            while (map.get(cur) != root){
//                String preParent = map.get(cur);
//                map.put(cur, root);
//                cur = preParent;
//            }
            return root;
        }

//        public int getSize(){
//            int size = 0;
//            for (String name : map.keySet()){
//                if (map.getOrDefault(name, "R").equals("R"))
//                    size ++;
//            }
//            return size;
//        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Set<String> set = new HashSet<>();
        ArrayList<String[]> lst = new ArrayList<>(n);
        for (int i = 0; i < n; i ++){
            String[] input = sc.nextLine().split(" ");
            lst.add(input);
            set.add(input[0]);
            set.add(input[1]);
        }

        DisjointSet ds = new DisjointSet(set.size());
        for (int i = 0; i < lst.size(); i ++){
            String[] input = lst.get(i);
            ds.union(input[0], input[1]);
        }

        System.out.println(ds.groupNum);

    }
}
