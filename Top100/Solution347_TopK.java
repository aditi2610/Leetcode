package Top100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution347_TopK {

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); // 1 3; 2 2; 3 1
        }
        // 1 way
        // Stream<Map.Entry<Integer, Integer>> sorted =
        // map.entrySet().stream().sorted(Map.Entry.comparingByValue());
        // int t = 0;
        // for (Entry<Integer, Integer> entry : map.entrySet()) {
        // if (t < k) {
        // result[t] = entry.getKey();
        // t++;
        // }
        // }

        // 2 way
        List<Integer> list = map.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).limit(k)
                .map(i -> i.getKey()).collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;

        /**
         * sort the array first find the number at 0th index int temp = number[0] index
         * = 0; while temp = nums[i]; i++ once its is not subtract count = i- index;
         * 
         */

    }

    public static void main(String[] args) {
        Solution347_TopK topK = new Solution347_TopK();
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int[] res = topK.topKFrequent(nums, 2);
        for (int e : res) {
            System.out.print(e + " ");
        }
    }
}
