package DynamicProgramming;

public class Solution213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int start0 = calculateMax(0, nums.length - 2, nums);
        int start1 = calculateMax(1, nums.length - 1, nums);
        return Math.max(start0, start1);
    }

    int calculateMax(int start, int end, int[] nums) {
        int dp[] = new int[end];
        if (start == 0)
            dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[end];
    }

    public static void main(String args[]) {

        Solution213_HouseRobberII houseII = new Solution213_HouseRobberII();
        int[] nums = { 5, 4, 1, 0, 1 };
        System.out.println(houseII.rob(nums));

    }
}