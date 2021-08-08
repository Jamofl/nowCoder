import org.w3c.dom.CDATASection;

import javax.management.remote.JMXServerErrorException;
import java.util.*;
public class Q酒店价格 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 储存每一个的价格,列表索引为天数，element为价格

        int[] prices = new int[12000];
        while (sc.hasNext()) {
            //更新价格数组
            int start = sc.nextInt();
            int end = sc.nextInt();
            int price = sc.nextInt();
            for (int i = start; i <= end; i++) {
                prices[i] = price;
            }
        }
        System.out.print(handle(prices).toString());
    }

    public static StringBuffer handle(int[] prices) {
        StringBuffer buf = new StringBuffer();
        int n = prices.length;
        int i = 0;
        int startDay = 0;
        while (i < n - 1) {
            int currentPrice = prices[i];
            while (i < n - 1 && currentPrice == prices[i + 1]) {
                //价格跟之前一样，我们继续增加索引
                i++;
            }
            // 此时的i为当前价格的最后一天;
            if (prices[i] != 0) {
                buf.append("[").append(startDay).append(", ").append(i).append(", ")
                        .append(prices[i]).append("]").append(",");
            }
            // i变为新价格的第一天
            i ++;
            startDay = i;
        }
        //删除最后一个逗号
        return buf.deleteCharAt(buf.length() - 1);

    }



    public static int[][] merge(int[][] dateRangePrices){
        Arrays.sort(dateRangePrices, (int[] t, int[] s) -> t[0] - s[0]);
        LinkedList<int[]> ans = new LinkedList<>();
        ans.add(dateRangePrices[0]);

        int i = 1;
        while (i < dateRangePrices.length){
            int[] preInteval = new int[] {ans.getLast()[0], ans.getLast()[1]};
            int prePrice = ans.getLast()[2];

            int[] interval = new int[] {dateRangePrices[i][0], dateRangePrices[i][1]};
            int price = dateRangePrices[i][2];

            if (preInteval[1] + 1 < interval[0])
                ans.addLast(dateRangePrices[i]);

            else if (preInteval[1] + 1 == interval[0]){
                if (prePrice == price){
                    ans.removeLast();
                    int[] temp = new int[] {preInteval[0], Math.max(preInteval[1], interval[1]), price};
                    ans.add(temp);
                }
                else
                    ans.add(dateRangePrices[i]);
            }
            else{
                // 如果价格相等  直接合并区间
                if (prePrice == price){
                    ans.removeLast();
                    int[] temp = new int[] {preInteval[0], Math.max(preInteval[1], interval[1]), price};
                    ans.add(temp);
                }
                // 如果价格不相等
                else{
                    ans.getLast()[1] = Math.min(preInteval[1], interval[0]) - 1;
                    ans.addLast(dateRangePrices[i]);
                }
            }
            i ++;
        }
        return ans.toArray(new int[ans.size()][3]);
    }
}
