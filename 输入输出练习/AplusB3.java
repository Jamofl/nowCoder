package 输入输出练习;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/question/next?pid=27976983&qid=235781&tid=46194353
 */
public class AplusB3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> ans = new LinkedList<>();
        while (sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0)
                break;
            ans.add(a + b);
        }

        for (int x : ans)
            System.out.println(x);
    }
}
