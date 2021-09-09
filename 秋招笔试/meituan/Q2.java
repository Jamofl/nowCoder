package 秋招笔试.meituan;

import java.util.*;

/**
 * 现有n本书 要放到n个书架上去  每本书有一个厚度ai  每个书架也有一个宽度bi 必须满足ai <= bi 才能把书放进去 问共有多少种放书的方案
 * 如输入
 * 4 // 书的数目
 * 1 2 3 4 // 书的厚度
 * 2 4 3 4 // 书架的宽度
 *
 * 对于每本书 统计出可以放置的架子的个数  从后往前遍历 然后相乘起来就是总的方案数
 *
 *              1 2 3 4
 *              2 3 4 4
 * choices      4 4 3 2  所有书架中可以选择的个数
 * 真正可选      1 2 2 2  去掉那些已经占了位置的书，剩下的可以选择的个数
 */

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] books = new int[n];
        int[] shelves = new int[n];
        for (int i = 0; i < n; i ++){
            books[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i ++){
            shelves[i] = sc.nextInt();
        }
        Arrays.sort(books);
        Arrays.sort(shelves);

        long ans = helperCount(shelves, books);
        System.out.println(ans);
    }

    public static long helperCount(int[] shelves, int[] books){
        int n = books.length;
        int curPos = n - 1;
        long ans = 1;
        int lastBook = books[curPos];
        int count = 0;

        // choices表明当前的这本书在【所有的】书架中 有多少种选择。注意这里是所有的书架 所以计算结果时，需要减去当前已经占了坑位的书的个数
        int[] choices = new int[n];

        while (shelves[curPos] >= lastBook){
            count ++;
            curPos --;
        }
        choices[n - 1] = count;
        ans = ans * (choices[n - 1]);

        // 外层遍历O（n） 重点在于 如何优化内层遍历 在O（n）的时间复杂度里 统计出每一本书可以放置的位置的个数
        for (int k = n - 2; k >= 0; k --){

            int tempCount = 0;
            // 当前的位置大于0 且当前的架子宽度大于书的宽度
            while (curPos >= 0 && shelves[curPos] >= books[k]){
                tempCount ++;
                curPos --;
            }
            choices[k] = choices[k + 1] + tempCount; // 当前这本书可以放置的位置的个数 = 上一本可以放的位置的个数 + 比当前这本书大的书架的个数
            ans = ans * (choices[k] - (n - k - 1));  // 在所有书架中的选择个数 - 当前已经占了坑的书的个数
            ans = ans % (1_000_000_000 + 7);
        }
        return ans % (1_000_000_000 + 7);
    }
}
