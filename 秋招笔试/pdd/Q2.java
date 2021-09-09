/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package 秋招笔试.pdd;

import java.util.*;

/**
 * @author jam
 * @version Q2.java, v 0.1 2021年07月25日 20:11 jam
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scoreA = 0;
        int scoreB = 0;
        int n = sc.nextInt();
        LinkedList<Integer> lstA = new LinkedList<>();
        LinkedList<Integer> lstB = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            lstA.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            lstB.add(sc.nextInt());
        }
        // 模拟比赛
        ArrayList<Integer> desk = new ArrayList<>();
        boolean isA = true;
        int firstCard = -1;
        while (lstA.size() != 0 || lstB.size() != 0) {
            if (isA && lstA.size() > 0) {
                if (desk.size() == 0) {
                    int pop = lstA.removeFirst();
                    desk.add(pop);
                    isA = false;
                    firstCard = pop;
                }
                else {
                    int pop = lstA.removeFirst();
                    desk.add(pop);
                    if (pop == firstCard) {
                        scoreA += desk.size();
                        desk.clear();
                        isA = true;
                    }
                    else {
                        isA = false;
                    }
                }
                if (lstB.size() == 0)
                    isA = true;
            }
            else if (lstB.size() > 0) {
                if (desk.size() == 0) {
                    int pop = lstB.removeFirst();
                    desk.add(pop);
                    isA = true;
                    firstCard = pop;
                }
                else {
                    int pop = lstB.removeFirst();
                    desk.add(pop);
                    if (pop == firstCard) {
                        scoreB += desk.size();
                        isA = false;
                    } else {
                        isA = true;
                    }
                }
                if (lstA.size() == 0)
                    isA = false;
            }
            else if (lstA.size() == 0 && lstB.size() == 0) {
                break;
            }

        }
        if (desk.size() != 0) {
            for (int card : desk) {
                if (card % 2 == 0) {
                    scoreB++;
                }
                else {
                    scoreA++;
                }
            }
        }
        System.out.print(scoreA + " " + scoreB);
    }
}
/*
4
1 4 3 4
2 4 7 3
 */