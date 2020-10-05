package July10;


import java.util.ArrayList;
import java.util.List;

public class Solution257_BinaryPaths2 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();

        String s = new String(root.val+"");
        findChildren(root, s, list);
        return list;

    }

    private void findChildren(TreeNode root, String s, List<String> stringList) {

        if (root == null)
            return;
      //  s += root.val+"";
        if (root.left != null || root.right != null) {
            if (root.left != null) {
                //s +="->";
                findChildren(root.left, s+ "->"+root.left.val, stringList);
            }
            if (root.right != null) {
                //s+= "->";
                findChildren(root.right, s+ "->"+root.right.val, stringList);
            }
        } else {
            //String srt = s.toString();
            stringList.add(s);
            // s= new StringBuilder();
        }

    }

    public static void main(String args[]) {
        Solution257_BinaryPaths2 binaryPath = new Solution257_BinaryPaths2();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);

        List<String> list = binaryPath.binaryTreePaths(tree);
        for (String s : list) {
            System.out.println(s);
        }
    }
}