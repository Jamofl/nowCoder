package 携程;

import javax.security.auth.callback.TextInputCallback;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q0318_2 {

    private class Trie{

        public Node root;

        private class Node{
            public String val;
            public boolean isKey = false;
            public LinkedList<String> type;
            public Map<String, Node> next;

            public Node (String val){
                this.val = val;
                this.next = new HashMap<>();
            }
        }

        public Trie(){
            this.root = new Node("root");
        }

        public void insert(String word, String t){
            String[] arr = word.split("");
            Node point = root;
            for (int i = 0; i < arr.length; i ++){
                String letter = arr[i];
                if (point.next.getOrDefault(letter,  null) == null)
                    point.next.put(letter, new Node(letter));

                point = point.next.get(letter);
                if (i == arr.length - 1){
                    point.isKey = true;
                    point.type.add(t);
                }
            }
        }

        public LinkedList<String> contains(String word){
            String[] arr = word.split("");
            Node point = root;
            LinkedList<String> ans = new LinkedList<>();

            for (int i = 0; i < arr.length; i ++){
                String letter = arr[i];
                if (point.next.getOrDefault(letter, null) == null)
                    return ans;

                else{
                    point = point.next.get(letter);
                    if (point.isKey){
                        for (String t : point.type)
                            ans.add(t);
                    }
                }

            }
            return ans;
        }


    }

}
