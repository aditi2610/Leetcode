package Array_my;

import java.util.Arrays;

public class Solution41_LeastPositiveInteger {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length ==0)
            return 1;
        int index =0;
        Arrays.sort(nums);
        while(index < nums.length && nums[index]<= 0)
            index++;
       
        int k =1;
        while(index < nums.length){
            if(nums[index] == k){
                k++; 
                index ++;
            }else if( index  > 0  && nums[index] == nums[index-1]){
                index++;
            }else 
                return k;
        }
        return k;

       
    }
    public static void main(String args[]){

        Solution41_LeastPositiveInteger lpi = new Solution41_LeastPositiveInteger();
        //int[] nums = {0,1,2,3,3} ;
        //int[] nums = { 3,4,-1,1 };
        //int[] nums = {1,1,2,9,12};
        int[] nums = {0,-1,3,1};
        System.out.println(lpi.firstMissingPositive(nums));

    }
}