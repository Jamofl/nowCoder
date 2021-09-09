package 春招实习.MEITUAN;
import java.util.Scanner;

/*
一个球形西瓜，可以横着沿维度切，或者竖着沿经度切。 求切了n刀之后，整个球被划分成了几个部分。
输入为 第一行输入一个正整数，表示切了n刀。
后面n行，每一行第一个数t = 0，表示沿着纬度切；t = 1, 表示沿着经度切；
每行第二个数表示切的度数。经度取值范围[0,360)  纬度取值范围(0, 360)
所选的经度纬度均不会重复

输入示例
2      // 2行
1 0    // 经度 0
0 180  // 纬度 180

 */
public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 1;
        int longitude = 0;  // 竖着切 经度
        int latitude = 0;  // 横着切 纬度

        for (int i = 0; i < n; i ++){
            int flag = sc.nextInt();
            int temp = sc.nextInt();

            if (flag == 1){ // 经度
                if (longitude == 0) // 如果竖着没且过，说明从1个变为2个
                    ans *= 2;
                else { // 竖着且过了
                    if (latitude == 0) //如果横着没切过 每一刀多出来两个
                        ans += 2;
                    else
                        ans += (latitude + 1) * 2; // 如果横着切过了n刀， 每一刀多出来 (n + 1) * 2份
                }
                longitude ++;
            }
            else { // 纬度
                if (longitude == 0) // 如果竖着没且过，多出来一份
                    ans += 1;
                else if (longitude == 1) // 如果竖着切过一刀，多出来2份
                    ans += 2;
                else
                    ans += longitude * 2; // 竖着切过n刀，多出来2n份
                latitude ++;
            }
        }
        System.out.println(ans);
    }
}
