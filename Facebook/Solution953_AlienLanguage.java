package Facebook;

public class Solution953_AlienLanguage {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], order) > 0)
                return false;

        }
        return true;
    }

    int compare(String s1, String s2, String order) {
        int len = s1.length() < s2.length() ? s1.length() : s2.length();
        System.out.println("Comparing " + s1 + " " + s2);
        for (int i = 0; i < len; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                System.out.println("returning: " + (order.indexOf(c1) - order.indexOf(c2)));
                return order.indexOf(c1) - order.indexOf(c2);
            }

        }
        // thats is s1 is longer
        if (len != s2.length()) {
            System.out.println("length 1 ");
            return -1;
        }

        else if (len != s1.length()) {
            return 1;
        } else
            return 0;

    }

    public static void main(String[] args) {
        Solution953_AlienLanguage al = new Solution953_AlienLanguage();
        String[] words = { "fxasxpc", "dfbdrifhp", "nwzgs", "cmwqriv", "ebulyfyve", "miracx", "sxckdwzv", "dtijzluhts",
                "wwbmnge", "qmjwymmyox" };
        System.out.println(al.isAlienSorted(words, "zkgwaverfimqxbnctdplsjyohu"));
    }
}
