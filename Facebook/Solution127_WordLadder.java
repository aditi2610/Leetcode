package Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 1;
        boolean[] visited = new boolean[wordList.size()];
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (wordList.contains(beginWord)) {
            visited[wordList.indexOf(beginWord)] = true;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String s = queue.poll();
            for (int j = 0; j < wordList.size(); j++) {
                if (!visited[i] && compare(s, wordList.get(j))) {
                    if (wordList.get(j) == endWord)
                        return count + 1;
                    queue.add(wordList.get(j));
                    visited[j] = true;
                    count++;
                }
            }

        }

        return 0;
    }

    boolean compare(String word1, String word2) {
        int n = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                n++;
            }
        }

        if (n > 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Solution127_WordLadder ladder = new Solution127_WordLadder();
        List<String> list = new ArrayList<String>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        ladder.ladderLength("hit", "cog", list);
    }

}
