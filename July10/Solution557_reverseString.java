package July10;

public class Solution557_reverseString {
    public String reverseWords(String s) {
        String hel[] = s.split(" ");
       // StringBuilder response =new StringBuilder();

        StringBuilder strBuilder = new StringBuilder();
      for(int i =0; i<hel.length; i++){
          strBuilder.append(new StringBuffer(hel[i]).reverse()+ " ");
       
        // for(int  k = hel[i].length()-1; k>=0; k--){
        //     strBuilder.append(hel[i].charAt(k));
        // }
       
      }
        return strBuilder.toString().trim();
    }

    public static void main(String args[]){
        Solution557_reverseString reverseString  =new Solution557_reverseString();
        System.out.println(reverseString.reverseWords("Hello Babe"));
    }
}