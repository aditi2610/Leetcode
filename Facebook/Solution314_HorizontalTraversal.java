package Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import July10.TreeNode;

public class Solution314_HorizontalTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // List<Temp> list = new ArrayList<Temp>((a, b) -> a.left - b.left == 0 ?
        // a.depth - b.depth : a.left - b.left);
        List<Temp> list = new ArrayList<Temp>();
        list.add(new Temp(root, 0, 0));
        compute(root, 0, 0, list);
        Collections.sort(list, (a, b) -> a.left - b.left == 0 ? a.depth - b.depth : a.left - b.left);
        System.out.println(list.toString());
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> newL = new ArrayList<>();
        Temp temp = list.get(0);
        newL.add(temp.node.val);
        for (int i = 1; i < list.size(); i++) {
            if (temp.left != list.get(i).left) {
                result.add(newL);
                newL = new ArrayList<Integer>();

                temp = list.get(i);
            }
            newL.add(list.get(i).node.val);
        }
        result.add(newL);
        System.out.println(result.toString());
        return result;
    }

    void compute(TreeNode root, int depth, int left, List<Temp> list) {
        if (root == null)
            return;
        if (root.left != null) {
            list.add(new Temp(root.left, depth + 1, left - 1));
            compute(root.left, depth + 1, left - 1, list);
        }
        if (root.right != null) {
            list.add(new Temp(root.right, depth + 1, left + 1));
            compute(root.right, depth + 1, left + 1, list);
        }
    }

    class Temp {
        public int left;
        int depth;
        TreeNode node;

        Temp(TreeNode val, int depth, int left) {
            this.node = val;
            this.depth = depth;
            this.left = left;
        }

        @Override
        public String toString() {
            return node.val + " " + depth + " " + left;
            // return super.toString();
        }
    }

    public static void main(String[] args) {
        Solution314_HorizontalTraversal ht = new Solution314_HorizontalTraversal();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        ht.verticalOrder(node);
    }
}
