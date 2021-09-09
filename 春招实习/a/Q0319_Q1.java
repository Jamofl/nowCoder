package 春招实习.a;

import java.util.*;

public class Q0319_Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int[] counts = new int[n];

        for (int i = 0; i < n; i ++){
            int input = sc.nextInt();
            double sqt = Math.sqrt(input);
            if (Math.floor(sqt) == sqt)
                continue;
            else{
                counts[i] = distToNearestSquares(input);
            }
        }
        Arrays.sort(counts);

        for (int i = 0; i < counts.length / 2; i ++)
            ans += counts[i];
        System.out.println(ans);
    }

    private static int distToNearestSquares(int n){
        int low = (int) Math.floor(Math.sqrt(n));
        int high = (int) Math.ceil(Math.sqrt(n));
        return (n - low * low> high * high - n) ? high * high - n : n - low * low;
    }
}
