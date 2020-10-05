class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> oper = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;

            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (int) (s.charAt(i++) - '0');
                }
                nums.push(num);
                i--;
            } else {
                if (c == ')') {
                    int num = cal(nums, oper);
                    nums.push(num);
                } else {
                    oper.push(c);
                }
            }
        }
        return cal(nums, oper);
    }

    private int cal(Stack<Integer> nums, Stack<Character> oper) {
        int res = 0;
        while (nums.size() > 0) {
            int num = nums.pop();
            char op = '+';
            if (oper.size() > 0)
                op = oper.pop();
            if (op == '(') {
                res += num;
                break;
            }
            if (op == '+')
                res += num;
            else
                res -= num;
        }
        return res;
    }
}