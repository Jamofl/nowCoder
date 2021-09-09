// https://www.nowcoder.com/question/next?pid=1088888&qid=36827&tid=41681807
package 春招实习.华为笔试题;

import java.util.Scanner;
public class Q汽水瓶 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int num = sc.nextInt();
            if (num == 0)
                break;
            System.out.println(maxBottle(num,0));
        }
    }

    public static int maxBottle(int n, int ans){
        if (n < 2)
            return ans;
        else if (n == 2)
            return ans + 1;
        else{
            int q = n / 3;
            n = n % 3;
            return maxBottle(q + n, ans + q);
        }
    }
}
