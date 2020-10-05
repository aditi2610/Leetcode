package Aug4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import general.Node;

public class Solution590_PostOrderTraversal_Iterative {
    
    public List<Integer> postorder(Node root) {
        Stack<Node> stacking  = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Node cur = root;
        while(true){
            if(cur != null){
                for (Node tr : cur.children) {
                    stacking.push(tr);
                }
            }
            //not complete
            break;
           
               
            

        }

        return list;

        }
    }
