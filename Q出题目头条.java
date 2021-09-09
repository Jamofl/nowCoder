/*
https://exercise.acmcoder.com/online/online_judge_ques?ques_id=3339&konwledgeId=158
头条的2017校招开始了！为了这次校招，我们组织了一个规模宏大的出题团队。每个出题人都出了一些有趣的题目，而我们现在想把这些题目组合成若干场考试出来。在选题之前，我们对题目进行了盲审，并定出了每道题的难度系数。一场考试包含3道开放性题目，假设他们的难度从小到大分别为a, b, c，我们希望这3道题能满足下列条件：

春招实习.a＜= b＜= c
b - 春招实习.a＜= 10
c - b＜= 10

所有出题人一共出了n道开放性题目。现在我们想把这n道题分布到若干场考试中（1场或多场，每道题都必须使用且只能用一次），然而由于上述条件的限制，可能有一些考试没法凑够3道题，因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求。然而我们出题已经出得很累了，你能计算出我们最少还需要再出几道题吗？
 */
import edu.princeton.cs.algs4.UF;

import java.util.*;
public class Q出题目头条 {


    // 参考答案:  对数组排序后 动态遍历，若存在连续的三个差小于10的子序列，则不需要补充。若不满三，则补充。
    public static int solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0) {
            return 3;
        }
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        Arrays.sort(array);
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (tmp == 0) {
                tmp = 2;
                continue;
            }
            if (array[i] - array[i - 1] <= 10) {
                tmp--;
            } else {
                res += tmp;
                tmp = 2;
            }
        }
        res += tmp;

        return res;
    }

    public static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] problems = new int[n];
        for (int i = 0; i < n; i ++)
            problems[i] = sc.nextInt();
        Arrays.sort(problems);
        System.out.println(problemStillNeed(n, problems));
        //System.out.println(problemStillNeed(4, new int[]{17,20,27,50,60,70, 90,91, 120,125}));
    }

    private static class UnionFind{
        public int[] nums;
        public UnionFind(int n){
            this.nums = new int[n];
        }

        public void union(int i, int j){
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ)
                nums[rootJ] = nums[rootJ] + nums[rootI];
            else{
                nums[rootJ] = nums[rootJ] + nums[rootI];
                nums[rootI] = rootJ;
            }
        }

        public int find(int i){
            int start = i;
            int root = i;

            while (nums[i] >= 0){
                i = nums[i];
            }

            root = i;
            if (nums[i] < 0)
                return root;

            while (nums[start] != root){
                int temp = nums[start];
                nums[start] = root;
                start = temp;
            }
            return root;
        }
    }

    public static UnionFind uf;

    public static int problemStillNeed(int n, int[] problems){
        uf = new UnionFind(101); // 共100分的课程

        for (int i = 0; i < n ; i ++)
            uf.nums[problems[i]] = uf.nums[problems[i]] - 1; // 全部置为-1，若存在多个重复，则置为-3...


        for (int i = 1; i < n; i ++){
            if (problems[i - 1] >= problems[i] - 10){
                int rootI = uf.find(problems[i]);
                if (uf.nums[rootI] > -3){
                    uf.union(problems[i - 1], rootI);
                }
            }
        }

        int count = 0;
        for (int i = 0; i <= 100; i ++){
            if (uf.nums[i] < 0)
                count += uf.nums[i] - (-3);
        }
        return count;
    }
}
