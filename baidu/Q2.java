package baidu;
/*
有一个长度为n的数组，共有m个询问，询问有两种类型
1 l r, 询问区间l r 内有多少个子序列乘积为奇数
2 l r, 询问区间l r 内有多少个子序列乘积为偶数
（子序列指从原序列中去掉某些元素 但不破坏剩余元素的相对位置 而形成的新的序列）

输入为
4 2
1 2 3 4
1 1 3
2 1 3
即第一行分别表示n 和 m的个数
第二行表示数组
第三行和第四行表示询问的类型(1代表询问奇数，2代表询问偶数)

该案例输出为：
3 -> (1)  (1, 3)  (3)
4 -> (2)  (1, 2)  (1,2,3) (2,3)
 */
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[] nums = new int[n];
        for (int i = 0; i < n; i ++)
            nums[i] = sc.nextInt();
        sc.nextLine();

        // 通过前缀和计算累计的奇数个数
        int[] numOfOdd = new int[n];
        numOfOdd[0] = (nums[0] % 2 == 1) ? 1 : 0;
        for (int i = 1; i < n; i ++){
            numOfOdd[i] = numOfOdd[i - 1];
            if (nums[i] % 2 == 1)
                numOfOdd[i] ++;
        }

        int res[] = new int[m];
        for (int i = 0; i < m; i ++){
            int type = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();

            // 总共的子序列个数
            long NumOfSequence = (long) Math.pow(2, right - left + 1) - 1;
            // 乘积为奇数的子序列个数
            long NumOfOddSequence = (long) Math.pow(2, numOfOdd[right - 1] - numOfOdd[left - 1] + 1) - 1;
            if (type == 1) // 询问奇数
                res[i] = (int) (NumOfOddSequence % (1e9 + 7));
            else
                res[i] = (int) ((NumOfSequence - NumOfOddSequence) % (1e9 + 7));
        }
        for (int k = 0; k < m; k ++)
            System.out.println(res[k]);
    }

}
