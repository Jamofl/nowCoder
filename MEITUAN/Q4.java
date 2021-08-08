package MEITUAN;

import java.util.Scanner;

public class Q4 {

    public static int n;
    public static int k;
    public static int ans = Integer.MAX_VALUE;
    public static boolean hit = false;
    public static int[] Xs = new int[] {0,1,0,-1};
    public static int[] Ys = new int[] {-1,0,1,0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        Q4.n = n;
        Q4.k = k;

        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i ++){
            for (int j = 1; j <= n; j ++){
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i ++){
            for (int j = 1; j <= n; j ++){
                if (matrix[i][j] == 1)
                    dfs(matrix, i, j, 0);
            }
        }

        if (hit)
            System.out.println(ans);
        else
            System.out.println(-1);
    }

    // matrix 矩阵是从1 - n的！！！！！！！！！！！！！！！！1
    public static void dfs(int[][] matrix, int startI, int startJ, int sumDist){
        if (matrix[startI][startJ] == k){
            ans = Math.min(ans, sumDist);
            hit = true;
            return;
        }

        for (int k = 0; k <= 3; k ++){
            int newI = startI + Ys[k];
            int newJ = startJ + Xs[k];
            if (newI >= 1 && newI <= n && newJ >= 1 && newJ <= n && (matrix[newI][newJ] == matrix[startI][startJ] + 1)){
                int dist = calDist(startI, startJ, newI, newJ);
                dfs(matrix, newI, newJ, sumDist + dist);
            }
        }
    }

    private static int calDist(int oldI, int oldJ, int newI, int newJ){
        return Math.abs(oldI - newI) + Math.abs(oldJ - newJ);
    }
}
