package 春招实习.腾讯;

import java.util.Scanner;
import java.util.Stack;

public class Q2_Right {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String input = sc.nextLine();
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < n; i ++){
            int temp = input.charAt(i) - '0';
            if (stack.isEmpty() || temp + stack.peek() != 10)
                stack.push(temp);
            else
                stack.pop();
        }
        System.out.println(stack.size());
    }
}
