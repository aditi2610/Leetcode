package DynamicProgramming;

public class CombinationSum {
    int count = 0;

    int findWaysToSum(int n, int total) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        recursion(total, arr, 0);
        return count;
    }

    void recursion(int remaining, int[] n, int start) {
        if (remaining == 0) {
            count++;
            return;
        } else if (remaining < 0)
            return;

        for (int i = start; i < n.length; i++) {
            recursion(remaining - n[i], n, i);
        }

    }

    static int decode(String str) {
        int dp[] = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < str.length() + 1; i++) {
            if (str.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            if (str.charAt(i - 2) == '1' || (str.charAt(i - 2) == '2' && str.charAt(i - 1) < '7'))
                dp[i] += dp[i - 2];

        }
        return dp[str.length()];
    }

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        // System.out.println(sum.findWaysToSum(2, 3));
        System.out.println(sum.decode("12"));
    }
}
