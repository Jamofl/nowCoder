package ALI;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Q1_2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<Boolean> ans = new LinkedList<>();

        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n ; i ++)
                nums[i] =  sc.nextInt();

            Arrays.sort(nums);
            boolean[] visit = new boolean[n];

            ans.add(dfs(nums, visit,0, m));
        }

        for (boolean b : ans)
            if(b)
                System.out.println("YES");
            else
                System.out.println("NO");

    }


    private static boolean dfs(int[] nums, boolean[] visit, int start, int target){
        if (start > nums.length || target < 0)
            return false;

        else if (target == 0){
            return true;
        }

        boolean flag = false;
        for (int i = start; i < nums.length; i ++){
            if (visit[i])
                continue;
            if (i > 0 && !visit[i - 1] && nums[i] == nums[i - 1])
                continue;
            visit[i] = true;
            flag = flag || dfs(nums, visit, i + 1, target - nums[i]);
            visit[i] = false;
        }
        return flag;
    }



}
