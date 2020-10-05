package Aug4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution594_LongestHarmonious {
    public int findLHS(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }

        return res;

    }

    public static void main(String arsg[]) {
        Solution594_LongestHarmonious longest = new Solution594_LongestHarmonious();
        if ("aditi".compareTo("prachi") > 0)
            System.out.println("hey");
        else
            System.out.println("no");
        int[] num = { 1, 3, 2, 2, 5, 2, 3, 7 };
        System.out.println(longest.findLHS(num));
    }
}