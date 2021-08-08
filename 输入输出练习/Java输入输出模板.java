package 输入输出练习;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Java输入输出模板 {
    public static void main(String[] args) throws Exception{
        method1();
    }

    public static void method1(){
        //Scanner sc = new Scanner(new BufferedInputStream(System.in));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
            System.out.println(sc.next());
        System.out.println("end");
    }

    /*
    public static void method2() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null)
            System.out.println(line);
        System.out.println("end");
    }

     */
}
