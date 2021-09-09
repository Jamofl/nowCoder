package 春招实习.腾讯.Q4_18;

import java.util.LinkedList;

/*
给定一个链表，可以旋转该链表，返回字典序最小的链表
 */
import java.util.*;

public class Q1 {
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

        int n = lst.size();
        List<List<Integer>> col = new ArrayList<>(n);
        for (int i = 0; i < n; i ++){
            lst.addFirst(lst.removeLast());
            col.add(new LinkedList<>(lst));
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

        Collections.sort(col, cmp);
        List<Integer> ans = col.get(0);
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        for (int i : ans){
            node.next = new ListNode(i);
            node = node.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        Q1 q = new Q1();
        ListNode n3 = new ListNode(2,new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(2)))));
        ListNode n2 = new ListNode(5, new ListNode(4, new ListNode(23)));
        ListNode n = new ListNode(5,new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))));
        q.solve(n2);
    }
}
