package July10;

import java.util.Arrays;

public class Solution561_MinArray {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum =0;
        int i =0;
        for(i =0; i<nums.length; i+=2)
       {
            sum += nums[i];
           
        }

        return sum;

    }

    public static void main(String args[]){
        Solution561_MinArray minArray = new Solution561_MinArray();
        int num[] = {1,2,-3,4,1,1};
       System.out.println( minArray.arrayPairSum(num));
    }
}