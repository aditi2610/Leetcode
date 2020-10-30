package Facebook;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private final TrieNode root;

    public class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEndOfWord;

        TrieNode() {
            map = new HashMap<>();
            isEndOfWord = false;
        }
    }

    Trie() {
        root = new TrieNode();
    }

    // abcd , abd
    public void insert(String s) {
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            TrieNode temp = current.map.get(c);
            if (temp == null) {
                temp = new TrieNode();
                current.map.put(c, temp);
            }
            current = temp;
        }
        current.isEndOfWord = true;
    }

    public boolean search(String s) {
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            TrieNode temp = current.map.get(c);
            if (temp == null)
                return false;
            current = temp;
        }
        return current.isEndOfWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcd");
        trie.insert("abd");
    }
}
