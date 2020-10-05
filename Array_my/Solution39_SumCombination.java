package Array_my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39_SumCombination {
    

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int i=0; i< candidates.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            list  = helper(list, target-candidates[i], candidates);
        } 
    }

  

   

    public static void main(String args[]) {

        Solution39_SumCombination comboSum = new Solution39_SumCombination();
        int[] nums = {2,3,5};
        comboSum.combinationSum(nums, 7);
        
    }
}