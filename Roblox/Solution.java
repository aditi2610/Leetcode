package Roblox;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int sum = 0;
        Stack<Integer> stackNum = new Stack<Integer>();
        Stack<Character> stackChar = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            int prevNum = 0;
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            if (Character.isDigit(c)) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    prevNum = prevNum * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                stackNum.push((int) prevNum);
            } else if (c == ')') {
                int temp = calculateNum(stackChar, stackNum);
                stackNum.push(temp);

            } else {
                // if(c == '(' || c == '+' || c == '-')
                stackChar.push((char) c);
            }

        }

        return calculateNum(stackChar, stackNum);

    }

    int calculateNum(Stack<Character> stackChar, Stack<Integer> stackNum) {
        int result = 0;
        while (stackNum.size() > 0) {
            char operation = '+';
            int num = stackNum.pop();
            if (stackChar.size() > 0)
                operation = stackChar.pop();
            if (operation == '(') {
                result += num;
                break;
            } else if (operation == '+')
                result += num;
            else
                result -= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.calculate(" 2-1 + 2 ");
    }
}