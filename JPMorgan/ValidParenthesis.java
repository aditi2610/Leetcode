package JPMorgan;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char a : s.toCharArray()) {
            if (a == '(' || a == '[' || a == '{')
                stack.push(a);
            else if (a == ')' && stack.pop() != '(')
                return false;
            else if (a == '}' && stack.pop() != '{')
                return false;
            else if (a == ']' && stack.pop() != '[')
                return false;
        }
        if (stack.size() == 0)
            return true;
        else
            return false;
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;

        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = s.charAt(i - 1) == '0' ? 0 : dp[i - 1];
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))
                dp[i] += dp[i - 2];
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        ValidParenthesis va = new ValidParenthesis();
        if (va.isValid("()[({})]"))
            System.out.println("Its valid");
        System.out.println(va.numDecodings("22"));
    }
}
