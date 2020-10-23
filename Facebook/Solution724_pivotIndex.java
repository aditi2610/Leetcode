package Facebook;

public class Solution724_pivotIndex {
    public int pivotIndex(int[] nums) {
        /**
         * // what if numbers are neagtive start with left index =0; and right index
         * =length-1 if sumLeft < sumRight{ sumLeft += nums[left++]; if(sumRight <
         * sumLeft){ sumRight += nums[right--]; if they are equal but the right -left >
         * 1 // left++; } }
         */

        int left = -1, right = nums.length - 1;
        int leftSum = 0;
        int rightSum = 0;
        while (right - left >= 1) {
            if (leftSum < rightSum) {
                leftSum += nums[left++];
            } else {
                rightSum += nums[right--];
            }
            // else {
            // return left;
            // }
        }
        return left;

    }

    public static void main(String[] args) {
        Solution724_pivotIndex pivot = new Solution724_pivotIndex();
        int[] nums = { 1, 2, 3 };
        pivot.pivotIndex(nums);
    }
}
