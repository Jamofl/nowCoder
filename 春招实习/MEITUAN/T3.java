
package 春招实习.MEITUAN;

import java.util.*;

class T3 {
    static int k;
    static List<Integer> kList = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Q4 main = new Q4();
        int n = sc.nextInt();

        k = sc.nextInt();
        while (k > 0){
            kList.add(k % 10);
            k = k / 10;
        }

        int res = 0;
        while (n > 0){
            int cur = sc.nextInt();
            if (fun(factor(cur)))
                res ++;
            n --;
        }

        System.out.println(res);
    }



    public static boolean fun(List<Integer> list){
        int len = list.size();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i ++){
            int cur = list.get(i);
            if (! map.containsKey(cur))
                map.put(cur, new ArrayList<>());
            map.get(cur).add(i);
        }

        int previous = -1;
        for (int i = kList.size() - 1; i > -1; i --){
            if (! map.containsKey(kList.get(i)))
                return false;
            else{
                List<Integer> cache = map.get(kList.get(i));
                Collections.sort(cache);
                previous = helperFun(cache, previous);

                if (previous == -1)
                    return false;
            }
        }
        return  true;
    }

    public static List<Integer> factor (int n ){
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

    public static  int helperFun(List<Integer> cache, int k1){
        for (int i = 0; i < cache.size(); i ++){
            if (cache.get(i) > k1)
                return cache.get(i);
        }
        return -1;
    }
}

