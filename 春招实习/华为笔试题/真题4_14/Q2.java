package 春招实习.华为笔试题.真题4_14;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i ++)
            v[i] = sc.nextInt();

        int count = v[0];
        int co = 0;
        int abs = 0;
        int index = -1;
        int index_t = -1;

        for (int i = 1; i < n; i ++){
            co ++;
            if (v[i] + 9 <= v[i - 1]){
                abs ++;
                if (abs == 4)
                    index = index - 4;
                else if (abs == 1)
                    index = i;
            }
            else if (abs < 4)
                abs = 0;
            else{
                for (int j = Math.max(index, index_t); j < n && j <= i + 3; j ++)
                    System.out.println("," + v[j]);
                abs = 0;
                index_t = i + 4;
            }

            if (i == n - 1 && abs >= 4){
                for (int j = Math.max(index, index_t); j < n && j <= i + 3; j ++)
                    System.out.println("," + v[j]);
                return ;
            }

            if (abs >= 4)
                co = 0;

            if (co == 60){
                System.out.println("," + v[i]);
                co = 0;
            }
        }

    }
}
