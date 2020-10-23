package Facebook;

import java.util.ArrayList;
import java.util.List;

import general.TreeNode;

public class Solution257_RootToLeaf {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        backtrack(result, root, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> finalResult, TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }
        int length = stringBuilder.length();
        stringBuilder.append(root.val);

        if (root.left == null && root.right == null) {
            finalResult.add(new StringBuilder(stringBuilder).toString());
        } else {

            stringBuilder.append(" -> ");
            backtrack(finalResult, root.left, stringBuilder);
            backtrack(finalResult, root.right, stringBuilder);
            stringBuilder.setLength(length);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
        Solution257_RootToLeaf root = new Solution257_RootToLeaf();
        root.binaryTreePaths(node);
    }
}
