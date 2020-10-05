package Aug4;

import java.util.Iterator;
import java.util.List;

import general.TreeNode;

public class Solution637_avgBinaryTree {
    
    public List<Double> averageOfLevels(TreeNode root) {

    }


    int calculateSum(TreeNode left , TreeNode right, List list){
        if(left == null && right == null)
            

        
        return 0;

    }
    public static void main(String args[]){
        Solution637_avgBinaryTree avgBinTree = new Solution637_avgBinaryTree();
        TreeNode tree= new TreeNode(1);
        tree.left= new TreeNode(2);
        tree.right = new TreeNode(3);
        avgBinTree.averageOfLevels(tree);
        
    }
    
}