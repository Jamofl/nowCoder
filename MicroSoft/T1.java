package MicroSoft;

public class T1 {

    public int solution(int[] A) {
        // write your code in Java SE 8

        if (A == null)
            return 0;

        int n = A.length;
        if (n <= 1)
            return  0;

        else if (n == 2){
            if ((A[0] + A[1]) % 2 == 0)
                return 1;
            else
                return 0;
        }

        // n >= 2
        else{
            int i = 0;
            int count = 0;
            while (i <= n - 2){
                if ((A[i] + A[i + 1]) % 2 == 0){
                    count ++;
                    i = i + 2;
                }
                else
                    i = i + 1;
            }

            // special case 如果前两个元素没有构成偶数对，且最后两个元素也没构成偶数对，判断最后一个元素是否会和第一个元素构成偶数对
            if (((A[0] + A[1]) % 2 != 0) && ((A[n - 1] + A[n - 2]) % 2 != 0) && ((A[n - 1] + A[0]) % 2 == 0)){
                count ++;
            }

            return count;
        }
    }

    public static void main(String[] args){
        T1 t = new T1();
        int r = t.solution(new int[] {3,4,6,9,7});
        System.out.println(r);
    }

}
