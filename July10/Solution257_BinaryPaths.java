package July10;

import java.util.ArrayList;
import java.util.List;


public class Solution257_BinaryPaths {
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();

        StringBuilder s = new StringBuilder(root.val + "");
        findChildren(root, s, list);
        return list;

    }

    private void findChildren(TreeNode root, StringBuilder s, List<String> stringList) {
        if (root == null)
            return;
        if (root.left != null || root.right != null) {
            if (root.left != null) {
                //s +="->";
                findChildren(root.left, s.append("->"+root.left.val), stringList);
            }
            if (root.right != null) {
                //s+= "->";
                findChildren(root.right, s.append("->" +root.right.val), stringList);
            }
        } else {
            stringList.add(s.toString());
        }
    }
    public static void main(String args[]){
        Solution257_BinaryPaths binaryPath = new Solution257_BinaryPaths();
        TreeNode tree = new TreeNode(1);
        tree.left  = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);

        List<String> list = binaryPath.binaryTreePaths(tree);
        for (String s: list){
            System.out.println(s);
        }
    }
}