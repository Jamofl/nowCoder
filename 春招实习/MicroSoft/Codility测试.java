/*
Write 春招实习.a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
package 春招实习.MicroSoft;

import java.util.*;
class Codi {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();
        for (int n : A)
            set.add(n);

        int index = 1;
        while (true){
            if (!set.contains(index))
                return index;
            index ++;
        }
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] {1,3,5,1,6,8,0,3,6,7,8,9,2,5}));
    }
}
