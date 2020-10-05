package DropBox;

import java.util.ArrayList;
import java.util.List;

public class Comparerfss {
    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        List<Integer> list = new ArrayList<Integer>();
        for (String word : query) {
            int count = 0;
            // for each word i will check if their is a match in the dictionary
            for (String dicTWord : dictionary) {
                if (isAnagram(dicTWord, word))
                    count++;
            }
            list.add(count);
            // match would be a seperate function which would check if all teh strings of
            // word are in that wor
        }
        return list;

    }

    public static boolean isAnagram(String dictWord, String word) {
        System.out.println("Comparing: " + dictWord + " " + word);
        boolean flag = false;
        int num = 0;
        if (dictWord.length() == word.length()) {
            // Map<Character, Integer> map = new HashMap<>();
            for (char c : word.toCharArray()) {
                if (dictWord.indexOf(c) < 0) {
                    return false;
                } else {
                    num++;
                    // map.put(c, map.getOrDefault(c,0)+1);
                }

            }
            if (num == word.length())
                return true;

        }

        return flag;
    }

    public static void main(String[] args) {
        Comparerfss comparerfss = new Comparerfss();
        List<String> dictionary = new ArrayList<String>();
        // dictionary.add("heater");
        dictionary.add("colod");
        List<String> query = new ArrayList<String>();
        query.add("cold");
        List<Integer> l = comparerfss.stringAnagram(dictionary, query);
        System.out.println(l);
    }
}
