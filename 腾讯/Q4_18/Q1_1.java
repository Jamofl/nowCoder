package 腾讯.Q4_18;

import javax.sql.rowset.serial.SQLInputImpl;
import java.util.*;

/*
给定一个链表，可以旋转该链表，返回字典序最小的链表
 */

public class Q1_1 {
    private static class ListNode{
        public int val;
        ListNode next = null;

        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }

        public ListNode(int val){
            this.val = val;
        }
    }


    public ListNode solve(ListNode s){
        LinkedList<Integer> lst = new LinkedList<>();
        ListNode cur = s;
        while (cur != null){
            lst.addLast(cur.val);
            cur = cur.next;
        }

        Comparator<List<Integer>> cmp = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer>  l1, List<Integer> l2) {
                for (int i = 0; i < l1.size(); i ++){
                    int n1 = l1.get(i);
                    int n2 = l2.get(i);
                    if (n1 < n2)
                        return -1;
                    else if (n1 > n2)
                        return 1;
                    else
                        continue;
                }
                return 0;
            }
        };

        int n = lst.size();
        List<Integer> ans = new LinkedList<>(lst);
        for (int i = 0; i < n; i ++){
            lst.addFirst(lst.removeLast());
            if (cmp.compare(ans, lst) > 0)
                ans = new LinkedList<>(lst);
        }

        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        for (int i : ans){
            node.next = new ListNode(i);
            node = node.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        Q1_1 q = new Q1_1();
        ListNode n3 = new ListNode(2,new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(2)))));
        ListNode n2 = new ListNode(5, new ListNode(4, new ListNode(23)));
        ListNode n = new ListNode(5,new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))));
        q.solve(n);
    }
}
