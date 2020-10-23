package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47_PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        /**
        *
        */

        List<List<Integer>> finalList = new ArrayList<>();
        Arrays.sort(nums);
        boolean used[] = new boolean[nums.length];
        backtrack(finalList, nums, 0, new ArrayList<Integer>(), used);
        return finalList;
    }

    void backtrack(List<List<Integer>> finalList, int[] nums, int start, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            finalList.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backtrack(finalList, nums, i, list, used);
                list.remove(list.size() - 1);
                used[i] = false;

                while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }

    }

    public static void main(String[] args) {
        Solution47_PermutationII perm = new Solution47_PermutationII();
        int[] nums = { 1, 1, 2 };
        System.out.println(perm.permuteUnique(nums));
    }
}
