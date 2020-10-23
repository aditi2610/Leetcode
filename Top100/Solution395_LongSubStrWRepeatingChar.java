package Top100;

import java.util.HashMap;
import java.util.Map;

public class Solution395_LongSubStrWRepeatingChar {

    // "ababbc"
    public int longestSubstring(String s, int k) {
        /**
         * 1.create base cases 2.create a map of all the unique characters, and their
         * frequency in the given string 3. now if the frequency of any char is less
         * than k, this char cannot be a part fo this subString, hence break at this
         * index 4. At this point checkRecursively for (0, index) 4. now incremennt end
         * until the map.get(end) <k 5. check recursively for the index+1, s.length
         */
        // map will have a 2,
        // b= 3
        // c =1
        if (k == 0 || s.length() < k)
            return 0;
        if (k == 1)
            return s.length();
        // create a map to store each character and count
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int end = 0;
        while (end < s.length() && map.get(s.charAt(end)) >= k) {
            end++;
        }
        if (end == s.length())
            return end;
        int ls1 = longestSubstring(s.substring(0, end), k);
        while (end < s.length() && map.get(s.charAt(end)) < k) {
            end++;
        }
        int ls2 = 0;
        if (end < s.length()) {
            ls2 = longestSubstring(s.substring(end), k);
        }

        return Math.max(ls1, ls2);
    }

    public static void main(String[] args) {

        Solution395_LongSubStrWRepeatingChar lon = new Solution395_LongSubStrWRepeatingChar();
        System.out.println(lon.longestSubstring("ababbc", 2));

    }
}