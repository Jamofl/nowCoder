/*
(+ 2 3)  -> 5
(* 1 2 3 4) -> 24
(- 9 1 2 3) -> 3
 */
import java.util.*;
public class Q携程计算器 {
    public static void main(String[] args){
        System.out.println(calculator("(+ 1 21 (* 3 4) (- 9 1))"));
    }

    public static  Stack<Character> stack = new Stack<>();
    public static  Set<Character> set = Set.of('(', ')', '+', '-', '*');
    public static int calculator(String exp){

        // 先通过反向stack处理大于9的数字,比如21，可以得到21， 而不是2 和 1
        // ( + 1 21 )
        Stack<Character> tempStack = new Stack<>();
        int num = 0;
        for (char c : exp.toCharArray()){
            if (set.contains(c)){
                if (num != 0){
                    tempStack.push((char) (num + '0'));
                    num = 0;
                }
                tempStack.push(c);
            }
            else if (Character.isDigit(c))
                num = num * 10 + c - '0';
            else if (c == ' '){
                if (num != 0){
                    tempStack.push((char) (num + '0'));
                    num = 0;
                }
            }
        }

        // 将反向stack中的内容全部入栈到正向stack中
        while (tempStack.size() != 0){
                stack.push(tempStack.pop());
        }
        return cal(stack);

    }

    public static int cal(Stack<Character> stack){
        char c = stack.pop();

        // 递归计算后面的值
        if (c == '(')
            return cal(stack);

        // 获取两个操作数
        int operator1;
        int operator2;
        // 若不为操作符 ( ) + - * ,即 是一个 self-evaluating的值，直接返回即可
        if (!set.contains(stack.peek()))
            operator1 = stack.pop() - '0';
        // 递归计算operator1 的值
        else
            operator1 = cal(stack);


        if (!set.contains(stack.peek()))
            operator2 = stack.pop() - '0';
        else
            operator2 = cal(stack);

        // 操作数是 +  -  * 三种情况
        if (c == '+'){
            int result = operator1 + operator2;
            // 说明当前计算结束，返回计算结果
            if (stack.peek() == ')'){
                stack.pop();
                return result;
            }

            // 将操作数和当前结算结果都入栈
            else{
                stack.push((char)(result + '0'));
                stack.push('+');
            }
        }
        else if (c == '*'){
            int result = operator1 * operator2;
            if (stack.peek() == ')'){
                stack.pop();
                return result;
            }
            else{
                stack.push((char)(result + '0'));
                stack.push('*');
            }

        }
        else if (c == '-'){
            int result = operator1 - operator2;
            if (stack.peek() == ')'){
                stack.pop();
                return result;
            }
            else{
                stack.push((char)(result + '0'));
                stack.push('-');
            }
        }
        return cal(stack);
    }

}
