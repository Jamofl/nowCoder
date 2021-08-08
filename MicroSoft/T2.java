package MicroSoft;

/*
给定一个数组，求最长的波谷的长度 （ A[I] >= A[J] <= A[K]），则A[J]为波谷
 */
public class T2 {

    // 错误方法
    public int solution(int[] blocks) {
        // write your code in Java SE 8
        int ans = 0;
        int n = blocks.length;
        int l = 1;
        int r = 1;
        int index = 1;
        if (blocks[1] >= blocks[0]){
            l = 0;
        }
        while (index <= n - 2){
            if (blocks[index] <= blocks[index - 1]){
                l ++;
            }
            else if (blocks[index] >= blocks[index - 1]){
                r ++;
                if (blocks[index] > blocks[index + 1]){
                    ans = Math.max(ans, l + r - 1);
                    l = 1;
                    r = 1;
                }
            }
            index ++;
        }
        return ans;
    }


    // 正确解法
    // 左 右分别扫描一次。
    // 从左往右扫描时，保留当前位置向左能跳到的最远位置；
    // 从右往左扫描时，保留当前位置向右能跳到的最远位置；
    public int solution2(int[] blocks){
        int ans = 1;
        int n = blocks.length;

        int[] leftDecrease = new int[n]; //表示从当前位置能往左跳到的最远位置
        leftDecrease[0] = 0;
        int start = 0;
        for (int end = 1; end < n; end ++){  // 1 ~ n - 1
            if (blocks[end] > blocks[end - 1])
                start = end;
            leftDecrease[end] = start;
        }

        int[] rightDecrease = new int[n]; //表示从当前位置能往右跳到的最远位置
        rightDecrease[n - 1] = n  - 1;
        start = n - 1;
        for (int end = n - 2; end > -1; end --){ // 0 ~ n - 2
            if (blocks[end] > blocks[end + 1])
                start = end;
            rightDecrease[end] = start;
            ans = Math.max(ans, rightDecrease[end] - leftDecrease[end] + 1);
        }

        ans = Math.max(ans, rightDecrease[n - 1] - leftDecrease[n - 1] + 1);
        return ans;
    }

    public  static  void main(String[] args){
        T2  t = new T2();
        int r = t.solution(new int[] {1,5,5,2,6});
        System.out.println(r);
    }


}
