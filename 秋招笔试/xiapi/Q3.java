/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.xiapi;
import   java.util.*;

/**
 * @author jam
 * @version Q3.java, v 0.1 2021年07月19日 14:55 jam
 */
public class Q3 {
    int getValue(int rowIndex, int columnIndex) {
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

}