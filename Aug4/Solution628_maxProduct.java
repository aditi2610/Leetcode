package Aug4;

import java.util.Arrays;

public class Solution628_maxProduct {
    public int maximumProduct(int[] nums) {
        /**
         * sort the numbers
         * pick the last number
         * check if the firstnumber is <0, 
         * if it is.. check if the second number should be 2nd last or 1st 
         * if 2nd last pick last 3 numbers, if 1 take 2nd number
         */
        int len = nums.length;
        Arrays.sort(nums);
      return Math.max(nums[0]*nums[1],  nums[len-2]*nums[len-3])* nums[len-1];
       //return product* nums[nums.length-1];
    }
    public static void main(String args[]){
        Solution628_maxProduct maxP = new Solution628_maxProduct();
        int[] nums = { -21, -20, 2, 3, 10, 20, 50};

        System.out.println(maxP.maximumProduct(nums));
        /**
         * case 1: -2,-1,5,10,20
         * case 2: -21, -20, 2, 3,10, 20, 50;
         * case 3: 1,3,4,6,7
         */

    }
}