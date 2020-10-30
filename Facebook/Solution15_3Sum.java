package Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int e1 = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(e1);
                    newList.add(nums[j]);
                    newList.add(nums[k]);
                    // System.out.println(newList.toString());
                    list.add(newList);
                    j++;
                    k--;
                    // for this scenario [-2,0,0,2,2]
                    // we want single
                    while (j < nums.length && nums[j] == nums[j - 1])
                        j++;
                    while (k > i - 1 && nums[k] == nums[k + 1])
                        k--;
                } else if (nums[j] + nums[k] > target)
                    k--;
                else
                    j++;
            }
        }

        return list;
    }
}
