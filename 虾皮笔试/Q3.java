/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 虾皮笔试;
import   java.util.*;

/**
 * @author jam
 * @version Q3.java, v 0.1 2021年07月19日 14:55 jam
 */
public class Q3 {
    public static int getValue(int rowIndex, int columnIndex) {
        // 第n行的m个数可表示为 C(n-1，m-1)，即为从n-1个不同元素中取m-1个元素的组合数。
        // write code here
        rowIndex = rowIndex - 1;
        columnIndex = columnIndex - 1;
        List<Integer> list = new LinkedList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i ++){
            list.add((int)(long) list.get(i - 1) * (rowIndex - i + 1) / i);
        }
        return list.get(columnIndex);
    }

    public static void main(String[] args) {
        int r = getValue(4,2);
        System.out.println(r);
    }


}