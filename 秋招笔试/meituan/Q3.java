package 秋招笔试.meituan;
import java.util.*;

/**
 * 给定一个随机字符串 如meituan 生成一个流会不断重复这个字符串，如meituanmeituanmeituan...
 * 现在想要生成一个目标字符串，求生成该目标字符串会浪费流中的多少个字符
 * 输入：
 * meituan
 * uta
 *
 * 输出
 * 10
 * 解释：
 * meituanmeituan  浪费了a前面的10个字符
 */
public class Q3 {

    /**
     * 模拟
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stream = sc.nextLine().trim();
        String pattern = sc.nextLine().trim();

        Map<Character, TreeSet<Integer>> hashmap = new HashMap<>();
        char[] streamChar = stream.toCharArray();
        char[] patternChar = pattern.toCharArray();

        int n = streamChar.length;
        int m = patternChar.length;
        for (int j = 0; j < n; j ++){
            if (! hashmap.containsKey(streamChar[j])){
                hashmap.put(streamChar[j], new TreeSet<>());
            }
            hashmap.get(streamChar[j]).add(j);
        }

        int oldIndex = -1;
        long answer = 0;
        for (int t = 0; t < m; t ++){
            if (!hashmap.containsKey(patternChar[t])){
                System.out.println(-1);
                return;
            }

            TreeSet<Integer> treeSet = hashmap.get(patternChar[t]);
            int currentIndex = treeSet.first();
            // ceiling 返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
            // 即该集合中不存在比给定oldIndex大的元素  不可以复用之前的流
            if (null == treeSet.ceiling(oldIndex)){  // currentIndex <= oldIndex
                answer += n - oldIndex - 1 + currentIndex;
                oldIndex = currentIndex;
            }
            // 集合中存在比index大的元素，可以复用当前的流
            else{
                int pop = treeSet.ceiling(oldIndex);
                answer += pop - oldIndex - 1;
                oldIndex = pop;
            }
        }
        System.out.println(answer);
    }
}
