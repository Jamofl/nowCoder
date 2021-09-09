package 春招实习.拼多多;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getDoubleHappyNum(n));
    }

    public static int getDoubleHappyNum(int n){
        int time = 1;
        while (true){
            if (isHappy(time * n))
                return time * n;
            time ++;
        }
    }

    private static boolean isHappy(int n){
        String str = String.valueOf(n);
        char[] arr = str.toCharArray();

        int[] check = new int[3];
        int x = -1;
        for (char c : arr){
            if (c == '0')
                check[0] ++;
            else if (c == '1')
                check[1] ++;
            else {
                check[2] ++;
                if (x == -1)
                    x = c - '0';
                else{
                    if (c - '0' != x)
                        return false;
                }
            }
        }
        return true;
    }
}
