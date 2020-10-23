package Facebook;

import java.util.Stack;

public class Solution678_ValidParethesis {

    public boolean checkValidString(String s) {
        Stack<Integer> stacka = new Stack<Integer>();
        Stack<Integer> stackb = new Stack<Integer>();
        if (s.length() == 0)
            return true;
        int i = 0;
        while (i < s.length()) {
            // System.out.println("i is: "+i);
            char c = s.charAt(i);
            if (c == '(')
                stacka.push(i);
            else if (c == '*')
                stackb.push(i);
            else {
                if (stacka.size() > 0) {
                    stacka.pop();
                }

                else if (stackb.size() > 0) {
                    stackb.pop();
                } else
                    return false;
            }

            i++;
            // System.out.println(i);
        }
        // System.out.println("stacka is Empty" + stacka.size());
        if (stacka.size() == 0) {
            // System.out.println("stacka is Empty");
            return true;
        }

        while (stacka.peek() < stackb.peek()) {
            stacka.pop();
            stackb.pop();
        }
        if (stacka.size() > 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Solution678_ValidParethesis valid = new Solution678_ValidParethesis();
        // valid.checkValidString("(*((((*");
        System.out.println(valid.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        // System.out.println(valid.checkValidString("(*(*())())()()((())((*"));
    }

}