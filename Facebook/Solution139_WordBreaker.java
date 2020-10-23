package Facebook;

import java.util.ArrayList;
import java.util.List;

public class Solution139_WordBreaker {

    public boolean wordBreak(String s, List<String> wordDict) {
        int canBreak[] = new int[s.length() + 1];
        canBreak[0] = 1;
        return check(0, wordDict, s, canBreak);
    }

    private boolean check(int startIndex, List<String> wordDict, String s, int[] canBreak) {
        if (canBreak[s.length()] == 1)
            return true;
        int currentIndex = startIndex + 1;
        while (currentIndex <= s.length()) {
            if (canBreak[currentIndex] == 0 && wordDict.contains(s.substring(startIndex, currentIndex))) {
                canBreak[currentIndex] = 1;
                if (check(currentIndex, wordDict, s, canBreak))
                    return true;
            }
            currentIndex++;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution139_WordBreaker bre = new Solution139_WordBreaker();
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        // list.add("leet");
        // list.add("cod");
        // list.add("code");
        System.out.println(bre.wordBreak("catsandog", list));
        // System.out.println(bre.wordBreak("leetcode", list));
    }
}
