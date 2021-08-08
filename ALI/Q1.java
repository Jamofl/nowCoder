package ALI;
import javax.swing.text.StyledEditorKit;
import java.util.*;
public class Q1 {


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

            ans.add(dfs(nums, 0, m));

        }

        for (boolean b : ans)
            if(b)
                System.out.println("YES");
            else
                System.out.println("NO");
    }


    private static boolean dfs(int[] nums, int start, int target){
        if (start > nums.length)
            return false;

        else if (target == 0){
            return true;
        }

        for (int i = start; i < nums.length; i ++){
            int num = nums[i];

            if (target - num >= 0){
                if (dfs(nums, i + 1, target - num) == true)
                    return true;
            }
        }
        return false;
    }



}
