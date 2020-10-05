package Array_my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution18_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int sum=0;
        Set<List<Integer>> finalList =new HashSet<List<Integer>>();
        Arrays.sort(nums);
        int  pointer_a, pointer_b;
        for(int i =0; i< nums.length-3; i++){
           for(int j =i+1; j< nums.length-2; j++){
               pointer_a = j+1;
               pointer_b = nums.length-1;
               while(pointer_a < pointer_b){
                   sum  = nums[i]+nums[j]+ nums[pointer_a]+ nums[pointer_b];
                   if(sum == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[pointer_a]);
                    list.add(nums[pointer_b]);
                    finalList.add(list);
                    pointer_a++;
                   }
                   else if(sum > target)
                    pointer_b--;
                   else 
                    pointer_a++;
               }
           }
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> trasfer: finalList){
                result.add(trasfer);
        }

        return result;
    
    }
    public static void main(String args[]){
        Solution18_4Sum sum4= new Solution18_4Sum();
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        List<List<Integer>>list = sum4.fourSum(nums, 0);
        System.out.println();
        for(List<Integer> l : list){
            System.out.print("[");
            for(Integer i: l){
                System.out.print(i+ " ");
            }
            System.out.println("]");
        
        }
    }
}