package MicroSoft;

import javafx.beans.property.SimpleObjectProperty;

public class T3 {

    public String solution(int U, int L, int[] C) {
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


}
