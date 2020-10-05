package Aug4;

import general.TreeNode;

public class Solution572_SubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s== null && t== null)
        return true;
        if(s == null || t == null)
        return false;
        if(s.val == t.val){
           if( isSubtree(s.left, t.left) && isSubtree(s.right, t.right))
            return true;
        }
        if(isSubtree(s.left, t) || isSubtree(s.right, t))
        return true;
        return false;

    }

    public static void main(String args[]){
        Solution572_SubTree subTree = new Solution572_SubTree();
        // TreeNode s = new TreeNode(1);
        // s.left  =new TreeNode(1);
        //  TreeNode t= new TreeNode(1);
        TreeNode s = new  TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        s.left.left = new TreeNode(4);
       // s.left.right = new TreeNode(5);
        s.right.left = new TreeNode(6);
        //s.right.right = new TreeNode(7);


        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(4);
        t.right =  new TreeNode(6);
        // //t.left.left =new TreeNode(5);

        System.out.println(subTree.isSubtree(s, t));
        
    }
}