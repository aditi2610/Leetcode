package Top100;
 
public class Solution10_regex{
    public boolean isMatch(String s, String p) {

        if(p.equals(".*"))
            return true;
        int i =0;
        int  j =0;
        while(i< p.length() && j< s.length()){
            if(p.charAt(i) == s.charAt(j) || p.charAt(i) =='.')
            {
                i++;
                j++;
            }
            else if(p.charAt(i)=='*'){
                while( j < s.length() && p.charAt(i-1) == s.charAt(j) ){
                    j++;
                }
                i++;
                
            }
            else if(p.charAt(i) != s.charAt(j)){
                if(i < p.length()-1 && p.charAt(i+1)== '*'){
                    i += 2;
                }
            }
              
        }

        if(j== s.length())
        return true;

        return false;
    }
    public static void main(String args[]){

        Solution10_regex regex = new Solution10_regex();
        //if (regex.isMatch("aab", "c*a*b"))
       //if( regex.isMatch("aa", "a*"))
       //if (regex.isMatch("aa", "a"))
        if (regex.isMatch("mississippi", "mis*is*ip*."))
       System.out.println("Yaayyyy!!! It matches");
       else
       System.out.println("No Match");

    }
}