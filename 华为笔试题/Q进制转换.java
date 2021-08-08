package 华为笔试题;

import java.util.*;
public class Q进制转换 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String input = sc.next();
            int re = Integer.parseInt(input.substring(2), 16);
            System.out.println(re);
        }
    }

}
