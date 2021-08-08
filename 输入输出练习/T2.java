package 输入输出练习;

import java.util.Arrays;
import java.util.Scanner;

/*
链接：https://ac.nowcoder.com/acm/contest/5657/H
来源：牛客网

题目描述
对输入的字符串进行排序后输出
打开以下链接可以查看正确的代码
https://ac.nowcoder.com/acm/contest/5657#question

输入描述:
输入有两行，第一行n

第二行是n个空格隔开的字符串
输出描述:
输出一行排序后的字符串，空格隔开，无结尾空格
示例1
输入
5
c d a bb e
输出
a bb c d e
 */
public class T2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextInt();

        String[] arr;
        arr = sc.nextLine().split(" ");
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i ++)
            System.out.print(arr[i] + " ");
        System.out.println(arr[arr.length - 1]);
    }
}
