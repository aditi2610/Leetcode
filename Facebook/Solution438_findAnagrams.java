package Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution438_findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<Integer>();
        // base case:
        // create a Map for p
        Map<Character, Integer> pMap = new HashMap<>();
        for (char i : p.toCharArray()) {
            pMap.put(i, pMap.getOrDefault(i, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        if (compare(sMap, pMap)) {
            list.add(0);
        }
        for (int j = p.length(); j < s.length(); j++) {

            // check if the character at j- p.length -1 == j
            char newChar = s.charAt(j);
            char oldChar = s.charAt(j - p.length());
            // if it is equal that means no change
            if (newChar == oldChar) {
                if (list.contains(j - p.length())) {
                    // add index
                    list.add(j - p.length() + 1);
                } else
                    continue;
            } else {
                // if it is not equal
                // add to the map and remover from the map
                if (sMap.get(oldChar) > 1) {
                    sMap.put(oldChar, sMap.get(oldChar) - 1);
                } else {
                    sMap.remove(oldChar);
                }
                sMap.put(newChar, sMap.getOrDefault(newChar, 0) + 1);
                if (compare(sMap, pMap))
                    list.add(j - p.length() + 1);
            }
        }

        return list;

        // if they are equal store the j-p.lnegth index;
        // next remove the first character and add the jth char

        // if they are equal add index to the list

    }

    private boolean compare(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
        for (Entry entry : sMap.entrySet()) {
            if (!pMap.containsKey(entry.getKey())) {
                return false;
            }

            // int num1 = pMap.get(entry.getKey());
            // int num2 = (int) entry.getValue();
            if (pMap.get(entry.getKey()) != (int) entry.getValue())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution438_findAnagrams ana = new Solution438_findAnagrams();
        StringBuilder sr = new StringBuilder();
        StringBuilder sr1 = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sr.append("a");
            sr1.append("a");
        }
        for (int i = 0; i < 10001; i++) {
            sr.append("a");
        }
        System.out.println(ana.findAnagrams(sr.toString(), sr1.toString()));
    }

}
