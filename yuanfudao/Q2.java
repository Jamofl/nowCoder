package yuanfudao;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i ++){
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        System.out.println(calIndex(nums, target));
        //System.out.println(calIndex(new int[] {7, 6, 6, 5, 15}, 14));
    }


    public static int calIndex(int[] nums, int target){
        int n = nums.length;
        if (n == 0)
            return 0;

        // n >= 1
        int i = 0;
        int j = 0;
        int result = nums[0];
        int resuiltWithoutFirst = 0;
        int sum = 0;


        while (j < n){
            if (result <= target){
                sum = sum % (1_000_000_000 + 7);
                sum += 1;
                j ++;

                if (j == n)
                    break;
                // O(1)
                result = result | nums[j];
                resuiltWithoutFirst = resuiltWithoutFirst | nums[j];
            }

            else{
                i ++;
                j = i;

                if (j < i){
                    j = i;
                    if (j == n)
                        break;
                    resuiltWithoutFirst = 0;
                    result = nums[i];
                }
                else
                    result = resuiltWithoutFirst;
            }
        }

        return sum;

//        while (j < n){
//            if (result <= target){
//                sum = sum % (1_000_000_000 + 7);
//                sum = j - i + 1;
//                j ++;
//                result = result | nums[j];
//            }
//
//            else{
//                i ++;
//                if (j < i){
//                    j = i;
//                    if (j == n)
//                        break;
//
//                    result = nums[i];
//                }
//
//                // j >= i
//                else {
//                    result = 0;
//                    for (int k = i; k <= j; k ++)
//                        result = result | nums[k];
//                }
//
//            }
//        }
//
//        return sum;
    }
}
