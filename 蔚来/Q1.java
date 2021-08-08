package 蔚来;

import java.util.*;
/*
https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Q1 {

    String[] NUMS = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public ArrayList<String> letterCombinations (String digits) {
        if (digits.equals(""))
            return new ArrayList<String>();
        ArrayList<String> ans = new ArrayList<>();
        dfs("", ans, digits);
        return ans;
    }


    private void dfs(String path, List<String> ans, String digits){
        if (digits.length() == 0){
            ans.add(path);
            return;
        }
        int index = digits.charAt(0) - '0' - 2;
        String aph = NUMS[index];
        for (int i = 0; i < aph.length(); i ++){
            dfs(path + String.valueOf(aph.charAt(i)), ans, digits.substring(1, digits.length()));
        }
    }

    public static void main(String[] args) {
        Q1 q = new Q1();
        List<String> ans = q.letterCombinations("34");
        System.out.println(ans);
    }
}
