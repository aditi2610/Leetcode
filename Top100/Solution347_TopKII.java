package Top100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution347_TopKII {

    public int[] topKFrequent(int[] nums, int k) {
        /**
         * 1. Count the freq of each element in the array 2. put the elements in the
         * heap of size 2 such that the key with max count is on top 3. and heap has
         * size == k 4. retrieve elements from heap and add them to the result.
         */
        if (nums.length == 1)
            return nums;

        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int i : nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> (countMap.get(b) - countMap.get(a)));

        for (int i : countMap.keySet()) {
            queue.add(i);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {

        Solution347_TopKII topKII = new Solution347_TopKII();
        // int[] nums = { 1, 1, 1, 2, 2, 3 };
        int[] nums = { -1, -1 };
        int[] res = topKII.topKFrequent(nums, 1);
        for (int i : res) {
            System.out.print(i + " ");
        }

    }
}
