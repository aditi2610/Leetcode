package July10;

import general.TreeNode;

public class Solution543_DiameterBinaryTree{
    public int diameterOfBinaryTree(TreeNode root) {
        return 0;
    }

    public int depth(TreeNode root){
        if(root == null)
        return 0;
         
         int left = depth(root.left);
         int right = depth(root.right);
         return Math.max(left,  right)+1;
    }

    public static void main(String args[]){
        Solution543_DiameterBinaryTree binTree = new Solution543_DiameterBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
       System.out.println( binTree.diameterOfBinaryTree(tree));

        
    }

}