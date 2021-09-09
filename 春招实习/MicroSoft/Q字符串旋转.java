/*
作者：KaitoHH
链接：https://www.nowcoder.com/discuss/520007?type=post&order=time&pos=&page=1&channel=-1&source_id=search_post_nctrack
来源：牛客网

题意：有一个空格分割的若干个单词组成的字符串，现在有一个n表示对每个单词做n次顺时针旋转，
现在给你旋转之后的的字符串，问有多少个单词在原来的字符串和旋转之后的字符串中一致。比如n=2,
字符串="ba def adad"，那么显然旋转之前的字符串是"ba fde adad"，所以有2个单词和原来一致。
解：模拟一下就好了，用python写特别简单。
 */
package 春招实习.MicroSoft;

public class Q字符串旋转 {
    public static void main(String[] args){
        System.out.println(fun("ab def adad", 2));
    }

    public static int fun(String exp, int n){
        String[] arr = exp.split(" ");
        int count = 0;
        for (int i = 0; i < arr.length; i ++){
            StringBuffer temp = new StringBuffer(arr[i]);
            int k = 0;
            while (k < n){
                char c = temp.charAt(0);
                temp = temp.deleteCharAt(0).append(c);
                k ++;
            }
            if (temp.toString().equals(arr[i]))
                count ++;
        }
        return count;
    }
}
