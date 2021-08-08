package 华为笔试题;

import java.lang.reflect.Array;
import java.util.*;

public class Q去重排序 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < n ; i ++){
                set.add(sc.nextInt());
            }
//            ArrayList<Integer> lst = new ArrayList<>(set);
//            Collections.sort(lst);
            for (int i : set)
                System.out.println(i);
        }
    }
}
