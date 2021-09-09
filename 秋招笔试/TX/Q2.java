package 秋招笔试.TX;

import java.util.*;
public class Q2 {
    public static Set<Integer> set;
    public static void main(String[] args) {
        set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        int temp;
        for (int i = 0; i < n; i ++){
             temp = sc.nextInt();
             helper(temp);
             A[i] = set.size() + 1;
             set.clear();
        }

        for (int i = 0; i < n; i ++){
            temp = sc.nextInt();
            helper(temp);
            B[i] = set.size() + 1;
            set.clear();
        }
        Arrays.sort(A);
        Arrays.sort(B);

        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while (p1 < A.length && p2 < B.length){
            if (A[p1] > B[p2]){
                p1 ++;
                p2 ++;
                count ++;
            }
            else{
                p1 ++;
            }
        }
        System.out.println(count);
    }

    public static void helper(int num){
        for (int i = 2; i <= num; i ++){
            if (num % i == 0){
                set.add(i);
//                helper(num / i);
            }
        }
    }
}
