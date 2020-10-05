package Aug4;

import java.util.ArrayList;
import java.util.List;

import general.Node;

public class Solution589_PreOrderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> response =new ArrayList<>();
        helper(root, response);
        return response;
    }

    void helper(Node root, List list){
        if(root == null)
        return;
        list.add(root.val);
        for(Node child: root.children)
            helper(child, list);


    }
        public static void main(String args[]){
            Node node= new Node(1);
            //node.val= 1;
            List<Node> list = new ArrayList<>();
            list.add(new Node(2));
            list.add(new Node(3));
            list.add(new Node(2));
            node.children = list;

            Solution589_PreOrderTraversal pre= new Solution589_PreOrderTraversal();
            pre.preorder(node);

            
        }
}