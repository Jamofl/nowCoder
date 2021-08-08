package ALI;
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(solution(nums, 0, 0, n - 1));
    }

    private static int solution(int[] nums, int score, int start1, int end2) {
        if (start1 == end2)
            return score;

        int leftScore = nums[start1];
        int rightScore = nums[end2];

        int end1 = start1;
        int start2 = end2;
        while (end1 <= start2) {
            if (end1 == start2 - 1)
                break;

            if (leftScore <= rightScore) {
                end1++;
                leftScore += nums[end1];
            } else {
                start2--;
                rightScore += nums[start2];
            }
            if (end1 == start2 - 1)
                break;
        }

        if (leftScore >= rightScore)
            return solution(nums, score + rightScore, start2, end2);
        else
            return solution(nums, score + leftScore, start1, end1);

    }
}
