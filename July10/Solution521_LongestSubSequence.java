package July10;

public class Solution521_LongestSubSequence {

    public int findLUSlength(String a, String b) {
        if(a== null || b == null)
            return 0;
        int len1= a.length(), len2 = b.length();
        if(a.equals(b))
                return -1;
        else
            return Math.max(len1, len2);
    }

    public static void main(String args[]){
        Solution521_LongestSubSequence longestSeq = new Solution521_LongestSubSequence();
        System.out.println(longestSeq.findLUSlength("abac", "aba"));
    }
}