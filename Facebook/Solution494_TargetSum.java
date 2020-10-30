package Facebook;

public class Solution494_TargetSum {

    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {

        int dp[][] = new int[nums.length + 1][2001];
        backTrack(nums, S, 0, 0, dp);
        return count;
    }

    int backTrack(int[] nums, int targetSum, int startIndex, int computedSum, int[][] dp) {
        // if we have reached the end of array return;
        if (startIndex == nums.length) {
            if (targetSum == computedSum) {
                return 1;

            }
            return 0;
        } else {

            int add = backTrack(nums, targetSum, startIndex + 1, computedSum + nums[startIndex], dp);

            int subtract = backTrack(nums, targetSum, startIndex + 1, computedSum - nums[startIndex], dp);
            dp[startIndex][computedSum] = add + subtract;
            return dp[startIndex][computedSum];
        }

    }

    public static void main(String[] args) {
        Solution494_TargetSum sum = new Solution494_TargetSum();
        int[] nums = { 1 };
        System.out.println(sum.findTargetSumWays(nums, 1));
    }
}
