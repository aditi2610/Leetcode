package Top100;

import java.util.ArrayList;
import java.util.List;

public class Solution46_Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        findPermutations(nums, list, new ArrayList<Integer>(), used);

        return list;
    }

    // 1 2 3
    private void findPermutations(int[] nums, List<List<Integer>> list, List<Integer> subList, boolean[] used) {
        if (nums.length == subList.size()) {
            System.out.println(subList);
            list.add(new ArrayList<>(subList));
            System.out.println(subList.size());
        } else {
            for (int i = 0; i < nums.length; i++) {
                System.out.println("Current i is: " + i);
                if (!used[i]) {
                    System.out.println("i not used is: " + i);
                    subList.add(nums[i]);
                    used[i] = true;
                    findPermutations(nums, list, subList, used);
                    subList.remove(subList.size() - 1);
                    used[i] = false;
                }

            }
        }
    }

    public static void main(String[] args) {
        Solution46_Permutation perm = new Solution46_Permutation();
        int[] nums = { 1, 2, 3 };
        System.out.println(perm.permute(nums));
    }
}
