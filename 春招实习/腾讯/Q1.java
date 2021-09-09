package 春招实习.腾讯;

/*
给定一棵二叉树，对该二叉树进行剪枝，返回一棵完全二叉树，使得该树尽可能的大。
如 给定 1 2 3 4 5 6 7 8
返回 1 2 3 4 5 6
 */
public class Q1 {

    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        Q1 q = new Q1();
        q.solve(tree);
        System.out.println(111);
    }

    public TreeNode solve (TreeNode root) {
        // write code here
        if (root == null)
            return null;
        cutPerfect(root);
        return root;
    }

    private TreeNode cutPerfect(TreeNode node){
        if (node == null)
            return null;

        node.left = cutPerfect(node.left);
        node.right = cutPerfect(node.right);
        if ((node.left == null && node.right == null) || (node.left != null && node.right != null))
            return node;
        else{
            node.left = null;
            node.right = null;
            return  node;
        }
    }


}
