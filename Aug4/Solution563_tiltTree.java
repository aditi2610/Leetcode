package Aug4;

import general.TreeNode;

public class Solution563_tiltTree {

    int tilt =0;
    public int findTilt(TreeNode root) {
    int left =0, right =0;
        if(root == null)
        return 0;
       left = calculateSum(root.left);
       right = calculateSum(root.right);
       tilt += Math.abs(left-right); 
       //we should have tilt as well for each node.
        return tilt;

    }

    
    private int calculateSum(TreeNode root) {
        int sum =0, leftSum=0, rightSum=0;
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        
        leftSum = calculateSum(root.left);
        rightSum = calculateSum(root.right);
        tilt += Math.abs(leftSum-rightSum);
        sum  = leftSum+rightSum+ root.val;
        return sum;
    }

    public static void main(String args[]) {
        Solution563_tiltTree tilt = new Solution563_tiltTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        //node.left.left = new TreeNode(4);
       // node.right =new TreeNode(3);
        //node.right.right = new TreeNode(5);
        node.left.left =new TreeNode(6);
        node.left.left.right = new TreeNode(8);
        System.out.println(tilt.findTilt(node));
    }
}