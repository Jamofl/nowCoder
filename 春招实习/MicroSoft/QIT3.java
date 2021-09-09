package 春招实习.MicroSoft;

import java.util.Arrays;

public class QIT3 {

    public String solutionOri(int U, int L, int[] C) {
        String imp = "IMPOSSIBLE";
        // write your code in Java SE 8
        if (C == null || C.length == 0)
            return imp;

        int n = C.length;
        int[] row1 = new int[n];
        int[] row2 = new int[n];
        int remainingOne = 0;

        for (int i = 0; i < n; i ++){
            // 将上下两行都置为1
            if (C[i] == 2){
                row1[i] = 1;
                row2[i] = 1;
                U --;
                L --;

                if (U < 0 || L < 0)
                    return imp;
                C[i] = 0;
            }
            else if (C[i] == 1)
                remainingOne ++;
        }

        // 若剩余1的总数和U + L不相等
        if (remainingOne != (U + L))
            return imp;

        // 建立row1和row2
        for (int i = 0; i < n; i ++){
            if (C[i] == 1){
                if (U > 0){
                    row1[i] = 1;
                    U --;
                }
                else{
                    row2[i] = 1;
                    L --;
                }
                if (U < 0 || L < 0)
                    return  imp;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i ++)
            res.append(row1[i]);
        res.append(",");
        for (int i = 0; i < n; i ++)
            res.append(row2[i]);
        return res.toString();
    }


    public String solution(int U, int L, int[] C) {
        int len = C.length;
        int[] row1 = new int[len];
        int[] row2 = new int[len];
        int sumOfC1 = 0;
        for (int i = 0; i < len; i ++)
            sumOfC1 += C[i];


        if (sumOfC1 != U + L)
            return "IMPOSSIBLE";


        for (int i = 0; i < len; i ++){
            if (C[i] == 2){
                row1[i] = 1;
                row2[i] = 1;
                U --;
                L --;
                C[i] = 0;
                sumOfC1 -= 2;
                if (U < 0 || L < 0)
                    return "IMPOSSIBLE";
            }
        }

        if (sumOfC1 != U + L)
            return "IMPOSSIBLE";

        for (int i = 0; i < len; i ++){
            if (C[i] == 1){
                if (L > 0){
                    row2[i] = 1;
                    L --;
                }
                else{
                    row1[i] = 1;
                    U --;
                }
                if (U < 0 || L < 0)
                    return "IMPOSSIBLE";
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i ++)
            stringBuilder.append(row1[i]);
        stringBuilder.append(",");
        for (int i = 0; i < len; i ++)
            stringBuilder.append(row2[i]);

        return stringBuilder.toString();
//        return String.valueOf(row1) + "," + String.valueOf(row2);
    }

    public static void main(String[] args){
        QIT3 q = new QIT3();
        int[] CK = new int[] {2, 1, 1, 0, 1};
        int U = 3;
        int L = 2;

        System.out.println("ori: " + q.solutionOri(U, L, Arrays.copyOf(CK, CK.length)));
        System.out.println("cur: " + q.solution(U, L, Arrays.copyOf(CK, CK.length)));
    }
}
