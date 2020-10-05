package DynamicProgramming;

public class Solution198_HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (dp == null || dp.length == 0)
            return 0;

        dp[0] = nums[0];
        if (nums.length > 2)
            dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String args[]) {
        Solution198_HouseRobber house = new Solution198_HouseRobber();
        int[] num = { 2, 1, 1, 2 };
        System.out.println(house.rob(num));

    }
}