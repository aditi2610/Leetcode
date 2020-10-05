package Aug4;

import general.TreeNode;

public class Solution617_Sum2Tree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return callHelper(t1, t2, null);
    }

    private TreeNode callHelper(TreeNode t1, TreeNode t2, TreeNode result) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        result = new TreeNode(t1.val + t2.val);
        result.left = callHelper(t1.left, t2.left, result);
        result.right = callHelper(t1.right, t2.right, result);
        return result;
    }

    public static void main(String args[]) {

        TreeNode root1 = new TreeNode(1);
        root1.left =new TreeNode(2);
        root1.right=new TreeNode(3);
        root1.left.left = new TreeNode(4);
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(5);
        root2.right= new TreeNode(6);
        root2.left.right = new TreeNode(5);

        Solution617_Sum2Tree sum2Tree = new Solution617_Sum2Tree();
        TreeNode result = sum2Tree.mergeTrees(null, root2);
        System.out.println(result.val);

    }
}