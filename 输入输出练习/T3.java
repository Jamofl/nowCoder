package 输入输出练习;
import java.util.*;


public class T3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String[] arr = sc.nextLine().split(" ");
            long ans = 0;
            for (String l : arr)
                ans += Long.parseLong(l);

            System.out.println(ans);
        }
    }
}
