package 秋招笔试.TX;
import java.util.List;

/**
 * 给定一堆链表，依次取出每条非空链表头，插入到答案串尾部，直到所有链表为空
 * [{1,2,3}, {4,5}, {7,8,9,10,11,12}]
 * ->
 *  {1,4,7,2,5,8,3,9,10,11,12}
 */

public class Q1 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    public ListNode solve (ListNode[] arr) {
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            boolean flag = true;
            int n = arr.length;
            while (flag){
                flag = false;
                for (int i = 0; i < n; i ++){
                    if (arr[i] != null){
                        flag = true;
                        p.next = arr[i];
                        p = p.next;
                        arr[i] = arr[i].next;
                    }
                }
            }
            return dummy.next;
    }
}
