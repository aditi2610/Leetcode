package StringPractise;

public class Solution151_reverseWords {
    
    public String reverseWords(String s) {
        StringBuilder st = new StringBuilder();
    
        String[] words = s.split(" ");
        int i =words.length-1; 
        while(i >= 0){
            if(words[i].trim().length() != 0){
                System.out.println("words is: " + words[i]);
                st.append(words[i]+ " ");
                //st.append(" ");
            }
             
            i--;
        }
        return st.toString().trim();
    }
    public static void main(String args[]){
        Solution151_reverseWords reverseWords = new Solution151_reverseWords();
       System.out.println(reverseWords.reverseWords("      a    good      example   "));
    }
}