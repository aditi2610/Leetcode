package Facebook;

public class Solution28_Strstr {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        if (haystack == null || haystack.length() == 0)
            return 0;
        if (needle == null || needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        while (i < haystack.length()) {
            char hc = haystack.charAt(i);
            char nc = needle.charAt(j);
            if (hc == nc) {

                // compare the rest of the string
                // if the index of i is already less than the needle.length-1
                // return false;

                if (i + needle.length() > haystack.length())
                    break;
                if (compareString(i, haystack, needle))
                    return i;
                // else
                // j++;
            }
            i++;
        }

        return -1;
    }

    private boolean compareString(int i, String haystack, String needle) {
        // int n = 1;
        for (int j = 1; j < needle.length(); j++) {
            char hc = haystack.charAt(j + i);
            char nc = needle.charAt(j);
            if (hc != nc)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution28_Strstr str = new Solution28_Strstr();
        System.out.println(str.strStr("ppi", "pi"));
    }
}
