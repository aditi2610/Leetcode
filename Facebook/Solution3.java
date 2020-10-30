package Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // take a Map to store the max Length till that index
        // when map containskey , size = last max-current len
        int leftPointer = 0;
        int rightPointer = 0;
        int result = 0;
        while (rightPointer < str.length() && leftPointer < str.length()) {
            char c = str.charAt(rightPointer);
            if (map.containsKey(c)) {
                result = Math.max(result, rightPointer - map.get(c));
                leftPointer = map.get(c);
                // compute the size and leftPointer ++
            }
            map.put(c, rightPointer);
            rightPointer++;
        }

        return Math.max(rightPointer - leftPointer, result);

    }

    public static void main(String[] args) {
        Solution3 sol3 = new Solution3();
        System.out.println(sol3.lengthOfLongestSubstring("aaaa"));
    }
}
