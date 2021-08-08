import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.Collections;
import java.util.Scanner;

/*
https://www.nowcoder.com/practice/46eb436eb6564a62b9f972160e1699c9?tab=answerKey
题目描述
给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。答案可能有多个，我我们需要找出长度最小的那个。
例如 N = 18 L = 2：
5 + 6 + 7 = 18
3 + 4 + 5 + 6 = 18
都是满足要求的，但是我们输出更短的 5 6 7
输入描述:
输入数据包括一行： 两个正整数N(1 ≤ N ≤ 1000000000),L(2 ≤ L ≤ 100)
输出描述:
从小到大输出这段连续非负整数，以空格分隔，行末无空格。如果没有这样的序列或者找出的序列长度大于100，则输出No
示例1
输入
复制
18 2
输出
复制
5 6 7
 */
// 1 2 3 4 5 6 7 8 9 10     12
// 1 3 6 10
//   2 5 9 14
//     3 7 12
public class Q序列和 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        int n = Integer.parseInt(arr[0]);
        int l = Integer.parseInt(arr[1]);
        minSequence(n,l);
    }


    // 方法1  滑动窗口
    // 若窗口中的数小于 n，左边界左移；若窗口中的数大于 n，右边界左移
    public static void minSequence(int n, int l){
        int i = n;
        int j = n;
        int sum = j;
        while (i >= 0 && i <= j){
            if (sum > n){
                sum = sum - j;
                if (i == j){
                    i --;
                }
                j --;
            }
            else if (sum < n){
                i --;
                sum = sum + i;
            }
            else{
                if (j - i + 1 >= l){
                    if (j - i + 1 <= 100){
                        for (int k = i; k < j; k ++)
                        System.out.print(k + " ");
                        System.out.print(j);
                        return;
                    }
                }
                else{
                    i --;
                    sum = sum + i;

                }
            }
        }
        System.out.println("No");
    }

    // 方法2 数学的方法  等差数列的前n项和公式  Sn = a1 * n + (n * (n - 1) * d) / 2
    public static void minSequence2(int n , int l){
        int i = l;
        while (i <= 100){
            double start = ((double) (2 * n) - i * (i - 1)) / (2.0 * i);
            if (Math.floor(start) == start){
                for (int j = (int) Math.floor(start); j < start + i - 1; j ++)
                    System.out.print((int)j + " ");
                System.out.print((int)start + i - 1);
                break;
            }
            i ++;
        }
        System.out.println("No");
    }
//        for (int i = n - 1; i >= 0; i --){
//            ans.clear();
//            sum = i;
//            ans.add(i);
//            for (int j = i - 1; j >= 0; j --){
//                sum = sum + j;
//                ans.add(j);
//                if (sum > n)
//                    break;
//                else if (sum == n){
//                    if (ans.size() >= l && ans.size() <= 100)
//                        return ans;
//                }
//            }
//        }

}
