package Aug4;

import java.util.Arrays;

public class Solution16_ThreeSum {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
    
        int sum = nums[0]+  nums[1]+ nums[nums.length-1];
        int ans = sum;
            int diff = Integer.MAX_VALUE;
        for(int i =0; i< nums.length-2; i++){
            int secondPointer = i+1;
            int thirdPointer = nums.length-1;
            while(secondPointer < thirdPointer){
                sum = nums[i] + nums[secondPointer] + nums[thirdPointer];
                if(sum > target){
                    thirdPointer--;
                }
                else{
                    secondPointer++;
                }

                if (diff > Math.abs(sum - target)) {
                    diff = Math.abs(sum - target);
                    ans = sum;
                }
            }

            

        }
        return ans;
    }

    public static void main(String args[]){
        Solution16_ThreeSum threeSum  = new Solution16_ThreeSum();
        int[] nums = {1,2,5,10,11};
       System.out.println( threeSum.threeSumClosest(nums, 12));

    }
}