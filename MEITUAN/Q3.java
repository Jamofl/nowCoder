package MEITUAN;


import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class Q3 {
    static int k;
    static List<Integer> KList = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();

        while (k > 0){
            KList.add(k % 10);
            k = k / 10;
        }

        int res = 0;
        while (n > 0){
            int cur = sc.nextInt();
            if (check(getFactor(cur)))
                res ++;
            n --;
        }
        System.out.println(res);
//        System.out.println(getFactor(10));
    }

    public static  int helperFun(List<Integer> cache, int previous){
        for (int i = 0; i < cache.size(); i ++){
            if (cache.get(i) > previous)
                return cache.get(i);
        }
        return -1;
    }

    public static boolean check(List<Integer> list){
        int len = list.size();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i ++){
            int num = list.get(i);
            if (! map.containsKey(num))
                map.put(num, new ArrayList<>());
            map.get(num).add(i);
        }

        int previous = -1;
        for (int i = KList.size() - 1; i > -1; i --){
            if (! map.containsKey(KList.get(i)))
                return false;
            else{
                List<Integer> memo = map.get(KList.get(i));
                Collections.sort(memo);
                previous = helperFun(memo, previous);

                if (previous == -1)
                    return false;
            }
        }
        return  true;
    }

    public static List<Integer> getFactor(int n){
        List<Integer> res = new ArrayList<>();
        res.add(1);

        for (int i = 2; i <= n; i ++){
            if (n % i == 0)
                res.add(i);
        }

        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        for (int i : res)
            sb.append(i);

        char[] chars = sb.toString().toCharArray();
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < chars.length; i ++){
            ret.add(chars[i] - '0');
        }
        return ret;
    }



}
