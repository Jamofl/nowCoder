package 输入输出练习;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/question/next?pid=27976983&qid=235780&tid=46194353
 */
public class AplusB2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> ans = new LinkedList<>();
        int n = sc.nextInt();

        for (int i = 0; i < n ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            ans.add(a + b);
        }

        for (int x : ans){
            System.out.println(x);
        }
    }
}
