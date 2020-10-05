package Aug4;

import general.TreeNode;

public class Solution606_ConstructStringFromBT {
    public String tree2str(TreeNode t) {
         StringBuilder response =  new StringBuilder();
          printCall(t, response);
          return response.toString();
        
    }


    private void printCall(TreeNode t, StringBuilder response) {
        if(t == null)
            return ;
        response.append(t.val);
        if(t.left != null){
            response.append("(");
            printCall(t.left, response);
            response.append(")");
        }
        if(t.left == null && t.right != null){
            response.append("()");
        }
        
        if(t.right != null){
            response.append("(");
            printCall(t.right, response);
            response.append(")");
        }
    }

    public static void main(String args[]) {
        TreeNode tree= new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right  = new TreeNode(3);
        tree.left.right= new TreeNode(4);

        Solution606_ConstructStringFromBT construct =new Solution606_ConstructStringFromBT();
        System.out.println(construct.tree2str(tree));

    }
}