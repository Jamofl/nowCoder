package 华为笔试题.真题3_31;
import java.util.Scanner;
import java.util.*;
/*
输入若干行，每一行的第一个参数为受损度，第二个参数为质量，第三个参数为标号；
找出受损度 <= 2, 质量 >= 20的零件。并按照如下规则排序：
表面受损度从小到大排序；若相同受损度，按质量从大到小；若受损度和质量都相同，按编号从小到大排序
输入实例：
1 20 11
5 20 53
2 40 54
6 10 22
1 30 10
2 40 23
输出：
1 30 10
1 20 11
2 40 23
2 40 54
 */
public class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> ans = new LinkedList<>();

        while (sc.hasNext()){
            int damage = sc.nextInt();
            int m = sc.nextInt();
            int seq = sc.nextInt();
            sc.nextLine();
            if (damage <= 2 && m >= 20){
                List<Integer> temp = new ArrayList<>(3);
                temp.add(damage);
                temp.add(m);
                temp.add(seq);
                ans.add(new ArrayList(temp));
            }
        }

        Comparator<List<Integer>> cmp = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                if (l1.get(0) != l2.get(0))
                    return l1.get(0) - l2.get(0);
                else{
                    if (l1.get(1) != l2.get(1))
                        return l2.get(1) - l1.get(1);
                    else
                        return l1.get(2) - l2.get(2);
                }
            }
        };
        Collections.sort(ans, cmp);

        for (int i = 0; i < ans.size(); i ++){
            List<Integer> temp = ans.get(i);
            System.out.print(temp.get(0) + " ");
            System.out.print(temp.get(1) + " ");
            System.out.println(temp.get(2));
        }
    }
}
