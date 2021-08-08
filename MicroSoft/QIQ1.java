package MicroSoft;
import java.util.*;

public class QIQ1 {
    public int Solution(int n){
        if (n < 10)
            return n;

        LinkedList<Integer> list = new LinkedList<>();
        while (n != 0){
            int r = n % 10;
            list.add(r);
            n = n / 10;
        }

        Collections.sort(list, (i, j) -> j - i);
        long re = 0l;
        while(list.size() > 0){
            int k = list.removeFirst();
            re = re * 10 + k;
            if (re * 10 > 1_000_000_000)
                return -1;
        }
        return (int)re;
    }

    public static void main(String[] args){
        QIQ1 q = new QIQ1();
        int[] tests = new int[] {12312,345345,657575,678678,1231,67878,24234,567567,678678678,234123,123123213};
        for (int i = 0; i < tests.length; i ++)
            System.out.println(q.Solution(tests[i]));
    }
}
