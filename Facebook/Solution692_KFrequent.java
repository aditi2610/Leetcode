package Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution692_KFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        /**
        */
        List<String> result = new ArrayList<String>();
        // create a HashMap
        Map<String, Integer> map = new HashMap<>();
        // iterate over the words
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // if map contains word, increase the count
        Queue<String> queue = new PriorityQueue<String>(k,
                (a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a));
        // System.out.println(queue);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry.getKey());
        }
        for (int l = 0; l < k; l++) {
            result.add(queue.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        Solution692_KFrequent kf = new Solution692_KFrequent();
        String[] words = { "ireyret", "lovely", "leetcode", "ireyret", "lovely", "lovely", "coding", "Prachi",
                "Subahsh", "Adti", "Aditya", "apor" };
        kf.topKFrequent(words, 2);
    }
}
