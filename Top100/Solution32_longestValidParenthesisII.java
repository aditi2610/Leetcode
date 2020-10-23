package Top100;

import java.util.Stack;

public class Solution32_longestValidParenthesisII {

    public int longestValidParentheses(String s) {

        /**
         * create a Stack which stores the indices of the element whenever you find a
         * "(" insert the index into the stack when you find ), check if the stack.size
         * >1 has an element other than -1 if yes, pop the element in the stack , when
         * you pop calculate the size by subtracting index - peek(); if not, add the
         * index of this element to the stack
         */

        Stack<Integer> indexStack = new Stack<>();
        int count = 0;
        indexStack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(')
                indexStack.push(i);
            else if (c == ')') {
                if (indexStack.size() > 1 && s.charAt(indexStack.peek()) == '(') {
                    indexStack.pop();
                    count = Math.max(count, i - indexStack.peek());
                } else {
                    indexStack.push(i);
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Solution32_longestValidParenthesisII par = new Solution32_longestValidParenthesisII();
        System.out.println(par.longestValidParentheses(")()())"));

    }
}
