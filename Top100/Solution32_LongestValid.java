package Top100;

import java.util.Stack;

public class Solution32_LongestValid {

    public int longestValidParentheses(String s) {
        /**
         * create 2 stacks, 1 to store the index and the other to store the characters
         * put -1 in the index Stack if we find '(' add it to both stacks if we find ')'
         * check if the stack has an element, if it has one pop the element from
         * charStack and from index stack.. cureentindex - peekindex = size of longest
         * valid parenthesis til now
         * 
         */

        Stack<Character> charStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int count = 0;
        indexStack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(') {
                charStack.push('(');
                indexStack.push(i);
            } else if (c == ')') {
                if (!charStack.isEmpty()) {
                    charStack.pop();
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
        Solution32_LongestValid longestValid = new Solution32_LongestValid();
        System.out.println(longestValid.longestValidParentheses(")()())"));
    }
}
