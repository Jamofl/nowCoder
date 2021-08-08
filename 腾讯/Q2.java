package 腾讯;

/*
给定一串由数字1-9组成的序列，若相邻的两个数字之和为10，则可以消掉。
如 213792 -》 22
求最终该序列可以被消为多长的序列

输入
6       // 第一行为序列的长度
213749  // 第二行为该序列

输出
2       // 被消减后该序列的长度
 */
import java.util.LinkedList;
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split("");
        LinkedList<Integer> lst = new LinkedList<>();
        for (String s : input)
            lst.add(Integer.parseInt(s));

        while (lst.size() > 1){
            // size >= 2
            int size = lst.size();
            int i = 0;
            while (i < lst.size()) {
                if (i <= lst.size() - 2 && (lst.get(i) + lst.get(i + 1) == 10)) {
                    lst.remove(i + 1);
                    lst.remove(i);
                }
                else if (i >= 1 && (lst.get(i) + lst.get(i - 1) == 10)){
                    lst.remove(i);
                    lst.remove(i - 1);
                }
                else
                    i++;
            }
            if (lst.size() == size)
                break;
        }

        System.out.println(lst.size());

    }
}
