package 携程;

import java.util.Arrays;

public class Q0318_1 {
    public static int calcSimilarity(String name1, String name2){
        String[] arr1 = name1.split(" ");
        String[] arr2 = name2.split(" ");
        if (arr1.length > arr2.length)
            return calcSimilarity(name2, name1);

        int sum = 0;
        for (int i = 0; i < arr1.length; i ++){
            String temp1 = arr1[i];
            String temp2 = arr2[i];
            sum +=  fun(temp1, temp2, "");
        }

        for (int j = arr1.length; j < arr2.length; j ++){
            sum += fun("", arr2[j], "");
        }

        return sum;
    }

    public static int fun(String temp1, String temp2, String path){
        if (temp1.equals(temp2))
            return cal(path);
        else if (temp1.length() == 0)
            return cal(path + temp2);
        else if (temp2.length() == 0)
            return cal(path + temp1);

        else if (temp1.charAt(0) == temp2.charAt(0)){
            return fun(temp1.substring(1), temp2.substring(1), path);
        }
        else{
            int r1 = fun(temp1.substring(1), temp2, path + temp1.charAt(0));
            int r2 = fun(temp1, temp2.substring(1), path + temp2.charAt(0));
            //int r3 = fun(temp1.substring(1), temp2.substring(1), path + temp1.charAt(0) + temp2.charAt(0));
            //return Math.min(r1, Math.min(r2, r3));
            return Math.min(r1, r2);
        }
    }

    public static int cal(String path){
        char[] charArr = path.toCharArray();
        int count = 0;
        for (char c : charArr)
            count += (int)(c);
        return count;
    }

    public static void main(String[] args){
        int r = calcSimilarity("at", "ta");
        System.out.println(r);

        System.out.println('a' + 'a');
//        String s = "你好吗";
//        String[] arr = s.split("");
//        System.out.println(Arrays.toString(arr));
    }
}
