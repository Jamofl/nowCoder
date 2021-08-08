/*
输入n张卡牌，两个数组A[i], B[i], 找到三张排i j k, 满足 i < j < k && a[i] <= a[j] <= a[k], 并且使得
B[i] + B[j] + B[k]的值最小,
 */
package a;
import java.util.*;
public class Q0319_Q2 {


    // 暴力枚举
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();

        for (int i = 0; i < n; i++)
            b[i] = scan.nextInt();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i ++) {
            for (int j = i + 1; j < n - 1 ; j ++){
                for (int k = j + 1; k < n; k ++){
                    if(a[i] <= a[j] && a[j] <= a[k]){
                        min = Math.min(b[i] + b[j] + b[k], min);
                    }

                }
            }
        }

        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}
