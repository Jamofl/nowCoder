/*
作者：KaitoHH
链接：https://www.nowcoder.com/discuss/520007?type=post&order=time&pos=&page=1&channel=-1&source_id=search_post_nctrack
来源：牛客网

给你一个J和K组成的字符串，要求改变其中的若干个字符，使得：
1) J和K的数量一致
2) 从左到右，K的数量始终多余J的数量。问你最少需要改变几个字符。
比如KKJJ、KJKJ、KKJJKJ都是合法的，但JK、KJJK、KKJ都是不合法的。
 */
package 春招实习.MicroSoft;

public class QKKJJ {
    public static void main(String[] args){
        QKKJJ q = new QKKJJ();
        int r = q.minmumCount("kkjjkjkjjk");
        System.out.println(r);
    }

    public int minmumCount(String exp){
        // n 为偶数
        int n = exp.length();
        int[][] dp = new int[n][n]; // 代表从i到j需要改变的次数
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++)
                dp[i][j] = n;
        }

        for (int j = 1; j < n; j = j + 1){ // 枚举结束位置j 间隔为1
            for (int i = j - 1; i >= 0; i = i - 2){ // 枚举开始位置i 间隔为2
                for (int k = i + 1; k <= j - 1; k = k + 2){ // 枚举中间位置k 间隔为2
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
                if (j == i + 1)
                    dp[i][j] = Math.min(dp[i][j], f(exp.charAt(i), exp.charAt(j)));
                else
                    dp[i][j] = Math.min(dp[i][j], f(exp.charAt(i), exp.charAt(j)) + dp[i + 1][j - 1]);
            }
        }
        return dp[0][n - 1];
    }

    private int f(char c, char t){
        if (c == t)
            return 1;
        else{
            if (c == 'j') // j ... k
                return 2;
            else          // k ... j
                return 0;
        }
    }
}
