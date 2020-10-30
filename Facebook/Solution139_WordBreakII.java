package Facebook;

import java.util.ArrayList;
import java.util.List;

public class Solution139_WordBreakII {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean isPossible[] = new boolean[s.length() + 1];
        return check(0, s, wordDict, isPossible);

    }

    boolean check(int startIndex, String s, List<String> wordDict, boolean isPossible[]) {
        for (int end = startIndex; end <= s.length(); end++) {
            if (!isPossible[end] && wordDict.contains(s.substring(startIndex, end))) {
                if (end == s.length())
                    return true;
                isPossible[end] = true;
                if (check(end, s, wordDict, isPossible))
                    return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution139_WordBreakII wbii = new Solution139_WordBreakII();
        List<String> list = new ArrayList<String>();
        // list.add("leet");
        // list.add("code");
        // System.out.println(wbii.wordBreak("leetcode", list));

        // list.add("cats");
        // list.add("cat");
        // list.add("sand");
        // list.add("and");
        // list.add("dog");
        // System.out.println(wbii.wordBreak("catsandog", list));
        list.add("aaaa");
        list.add("aaa");
        // list.add("sand");
        // list.add("and");
        // list.add("dog");
        System.out.println(wbii.wordBreak("aaaaaaa", list));
    }
}
