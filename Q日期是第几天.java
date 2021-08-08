import java.util.*;
public class Q日期是第几天 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String input = sc.next();
            System.out.println(nthDayOfYear(input));
        }
    }

    public static int nthDayOfYear(String data){
        String[] arr = data.split("/");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        int[] DAYS = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
        int ans = day;

        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3)
            ans ++;

        for (int i = 1; i < month; i ++)
            ans = ans + DAYS[i - 1];
        return ans;
    }

}
