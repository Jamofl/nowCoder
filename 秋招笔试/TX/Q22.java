package 秋招笔试.TX;
import java.util.*;

/**
 * 给定两个数组A B
 * 数组中每个数的攻击力定义为该数的因子个数
 * 现在A直到了B会按照1.2.3...n的顺序出战， 如果A以最优的顺序出牌，求A能赢得的回合数。
 */
public class Q22 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (map.containsKey(num))
                A[i] = map.get(num);
            else {
                int temp = getNumOfFac(num);
                A[i] = temp;
                map.put(num, temp);
            }
        }

        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (map.containsKey(num))
                B[i] = map.get(num);
            else {
                int temp = getNumOfFac(num);
                B[i] = temp;
                map.put(num, temp);
            }
        }
        Arrays.sort(B);
        Arrays.sort(A);

        int p1 = 0, p2 = 0;
        int count = 0;
        while (p1 < n && p2 < n){
            if (A[p1] <= A[p2]){
                p1 ++;
            }
            else{
                count ++;
                p1 ++;
                p2 ++;
            }
        }
        System.out.println(count);
        // System.out.println(getNumOfFac(8));
    }

    // 求一个数公因子的方法
    public static int getNumOfFac(int num) {
        int count = 0;
        int sqrt = (int) (Math.sqrt(num));
        for (int i = 1; i <= sqrt; i++) {
            if (num / i * i == num) // 等价于 num 能够整除 i， 说明有两个因子(除数  商各一个)
                count += 2;
        }
        if (sqrt * sqrt == num)// 如果num是个完全平方数 那么平方根就只有一个 需要减一
            count--;
        return count;
    }
}
