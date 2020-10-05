package Aug4;

import java.util.ArrayList;
import java.util.List;

import general.Node;

public class Solution590_PostOrderTraversal {
    
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
        
    }

    private void helper(Node root, List<Integer> result) {
        if(root == null)
        return;
       for(Node tr: root.children){
        helper(tr, result);
       }

       result.add(root.val);
    }
    
}