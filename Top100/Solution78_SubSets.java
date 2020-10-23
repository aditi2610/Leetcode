package Top100;

import java.util.ArrayList;
import java.util.List;

public class Solution78_SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        /**
         * calculate the list for varying size. for int size =0; size< nums.length;
         * sizee++ backtrack(finalList, 0, size, list);
         * 
         * //bactrack { if(size == list.size ) // add to the final List else { for(int i
         * = currentIndex; i< nums.length; i++ ){ list.add(nums[i]);
         * backtrack(finalList, i+1, ,size, list); list.remove(list.size()-1); } } }
         */
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        for (int size = 0; size <= nums.length; size++) {
            backtrack(finalList, size, 0, new ArrayList<Integer>(), nums);
        }
        return finalList;

    }

    void backtrack(List<List<Integer>> finalList, int size, int start, List<Integer> list, int[] nums) {
        if (size == list.size()) {
            System.out.println(list);
            finalList.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                backtrack(finalList, size, i + 1, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution78_SubSets subSets = new Solution78_SubSets();
        int[] nums = { 1, 2, 3 };
        subSets.subsets(nums);
    }
}
