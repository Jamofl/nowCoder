package 秋招笔试.baidu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q22 {
    public static Set<Character> set = new HashSet<>();
    public static void main(String[] args) {
        set.add('1');
        set.add('2');
        set.add('3');

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i ++){
            int num = sc.nextInt();
        }
        for (String  a : ans)
            System.out.println(a);
    }

    public static String getPerfectNum(String num){
        if (isPerfect(num))
            return num;
        char[] charArr = num.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = charArr.length - 1; i >= 0; i --){
            char c = charArr[i];
            if (i == 0 && (c == '0' || c == 'x'))
                break;
            // 1.属于1 2 3 直接保留
            if (set.contains(c))
                sb.append(c);

            // 2.为 0 或 -1 ：置为3 向上一位借位
            else if (c =='0' || c == 'x'){
                sb.append('3');
                // 向上一位借位
                if (charArr[i - 1] == '0'){
                    charArr[i - 1] = 'x'; // 'x'表示-1 也需要借位
                }
                else{
                    charArr[i - 1] -= 1;
                }
            }
            // c == 4 5 6 7 ....  置为3 不用借位
            else{
                sb.append('3');
            }
        }
        return sb.reverse().toString();
    }

    public static boolean isPerfect(String num){
        for (char c : num.toCharArray()){
            if (! set.contains(c))
                return  false;
        }
        return true;
    }
}
