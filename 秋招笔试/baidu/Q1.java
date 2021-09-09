package 秋招笔试.baidu;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] scaledMatrix = new int[n * k][n * k];
        for (int i = 0; i < n * k; i ++){
            for (int j = 0; j < n * k; j ++){
                scaledMatrix[i][j] = matrix[i / k][j / k];
            }
        }

        for (int i = 0; i < n * k; i ++){
            for (int j = 0; j < n * k; j ++){
                System.out.print(scaledMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
