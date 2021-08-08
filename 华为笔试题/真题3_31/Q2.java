package 华为笔试题.真题3_31;

import java.util.*;
/*
公司组织游戏，每位员工带有一顶帽子，员工反馈还有多少人和自己的帽子颜色相同，将这些信息放在info数组中，求参加游戏员工的最少数量
输入 [1, 1, 2]
输出 5
 */
public class Q2 {

    private static int minHat(int[] nums) {
        int res = 0;
        // 1.为帽子数 2.为同样帽子的人数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            int times = count / (key + 1); // 有几个圈子
            int mod = count % (key + 1);   // 余下的个数
            if (mod != 0) // 余下的个数不为0时，需要多一个圈子
                times++;
            res += (key + 1) * times;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();
        if (str.length() == 2) {
            System.out.println(0);
        }
        else {
            String sub = str.substring(1, str.length() - 1);
            String[] arr = sub.split(",");

            int[] nums = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                nums[i] = Integer.valueOf(arr[i].trim());
            }
            System.out.println(minHat(nums));
            reader.close() ;
        }
    }
    // [1]
    // [1, 1, 3]


}