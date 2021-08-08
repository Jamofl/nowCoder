package 蔚来;

import java.util.*;
/*
给定一个字符串序列，仅包含(){}[]，求是否能正常闭合。
e.g.
(){} -> true
({)] -> false
 */
public class Q5 {
    public static boolean isValid (String s) {
        if (s == null || s.length() == 0)
            return true;
        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        s1.add('{');
        s1.add('[');
        s1.add('(');
        s2.add('}');
        s2.add(']');
        s2.add(')');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (s1.contains(c)){
                stack.push(c);
            }
            else if (s2.contains(c)){
                if (stack.size() == 0)
                    return false;
                char pop = stack.pop();
                if (c == map.get(pop))
                    continue;
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "(){]";
        System.out.println(isValid(s));
    }

}
