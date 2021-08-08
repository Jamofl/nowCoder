package 华为笔试题.真题4_14;

import javax.print.DocFlavor;
import java.util.Scanner;
import java.util.*;

/*
将字符串从内层到外层逐一翻转
输入
(u(love)i)
输出
iloveu

输入
((jhku)(love)i)
输出
ilovejhku
 */
public class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(reverse(input));

    }

    private static String reverse(String input){
        Stack<Character> stack = new Stack<>();
        Deque<Character> lst = new LinkedList<>();
        for (char c : input.toCharArray()){
            if (c != ')')
                stack.push(c);
            else{
                while (stack.peek() != '(')
                    lst.offerFirst(stack.pop());
                stack.pop();

                while (lst.size() != 0)
                    stack.push(lst.pollLast());
            }
        }
        char[] ans = new char[stack.size()];
        for (int i = ans.length - 1; i >= 0; i --)
            ans[i] = stack.pop();
        return String.valueOf(ans);
    }
}
