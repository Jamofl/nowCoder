package 秋招笔试.拼多多2;


import java.util.LinkedList;
import java.util.Scanner;

public class Q3 {

    public static LinkedList<Integer> ansList;
    public static void main(String[] args) {
        ansList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        Integer t = Integer.valueOf(sc.nextLine().trim());
        LinkedList<Integer> NList = new LinkedList<>();
        LinkedList<Integer> MList = new LinkedList<>();
        for (int i = 0; i < t; i++) {
            Integer n1 = sc.nextInt();
            Integer n2 = sc.nextInt();
            NList.addLast(n1);
            MList.addLast(n2);
            solution(n1, n2);
        }
        for (int i = 0; i < t; i++)
            System.out.println(ansList.removeFirst());
    }

    public static void solution(Integer N, Integer M){
        Integer factor = 1;
        Integer ans = factor * M;
        while (true){
            String str = Integer.toString(ans);
            if (str.length() == N){
                ansList.addLast(ans);
                return;
            }

            if (str.length() > N){
                ansList.addLast(-1);
                return;
            }
            if (Integer.toString(factor * factor * M).length() < N)
                factor = factor * factor;
            else
                factor ++;
            ans = factor * M;

        }
    }
}
