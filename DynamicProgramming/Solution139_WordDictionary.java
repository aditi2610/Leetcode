package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Solution139_WordDictionary {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return false;
        boolean[][] matrix = new boolean[s.length() + 1][s.length() + 1];
        int select = 0;
        while (select < s.length()) {
            for (int i = 0; i + select < s.length(); i++) {
                if (wordDict.contains(s.substring(i, i + 1 + select)))
                    matrix[i][i + select] = true;
                else {
                    int div = 0;
                    while (div < select) {
                        if ((matrix[i][i + div]) && matrix[div + 1][i + select]) {
                            matrix[i][i + select] = true;
                            break;
                        }
                        div++;
                    }
                }
            }
            select++;
        }

        return matrix[0][s.length() - 1];
    }

    public static void main(String[] ars) {
        Solution139_WordDictionary wordDictionary = new Solution139_WordDictionary();
        List<String> list = new ArrayList<>();
        list.add("I");
        list.add("a");
        list.add("am");
        String s = "Iam";
        // System.out.println(s.substring(1, 3));
        System.out.println(wordDictionary.wordBreak("Iam", list));
    }
}