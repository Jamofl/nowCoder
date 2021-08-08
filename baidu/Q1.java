package baidu;
import java.util.Arrays;
import java.util.Scanner;

/*
跳格子，每次跳跃可以向后跳一步，或者跳到后面一个与当前位置数字相同的位置上，问需要多少步可以跳到位置n
如  5， 01212 则需要3步， 1-> 2 -> 3 -> 5;  若为5， 21202， 则需要1步，直接从第一个跳到最后一步
 */

public class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = sc.nextLine().split("");
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++)
            nums[i] = Integer.parseInt(arr[i]);

        System.out.println(minStep(nums));
    }

    public static int minStep(int[] nums){

        // dp[i] = min(dp[i - 1], temp[i]) + 1
        // 即要么是从前一个格子跳过来，要么是从上一个当前数字所在的格子跳过来，取二者中较小的那一个

        // temp[nums[i]] = math.min(temp[nums[i]], dp[i])
        // 即跳到上一个和当前数字相同的地方需要的最小步数，取较小者
        int n = nums.length;

        int[] TEMP = new int[10]; //表示跳到上一个和当前数字相同地方需要的步数
        Arrays.fill(TEMP, Integer.MAX_VALUE);

        int[] ans = new int[n];
        TEMP[nums[0]] = 0;
        ans[0] = 0;

        for (int i = 1; i < n; i ++ ){
            ans[i] = Math.min(TEMP[nums[i]], ans[i - 1]) + 1;
            TEMP[nums[i]] = Math.min(ans[i], TEMP[nums[i]]);
        }
        return ans[n - 1];
    }
}
