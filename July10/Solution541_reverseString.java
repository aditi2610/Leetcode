package July10;

public class Solution541_reverseString {
    public String reverseStr(String s, int k) {

        StringBuilder strResponse = new StringBuilder();
       int counter = s.length()/k;
       int sr = 0;

       while(sr< counter){
           if(sr %2 ==0){
               StringBuilder tempRev = new StringBuilder();
               for (int r = ((k * sr) + k-1); r >= ((k * sr)); r--) {
                   tempRev.append(s.charAt(r));
                   // store the value in another String
               }
               strResponse.append(tempRev);
           }else {
               strResponse.append(s, k*sr, (k*sr)+k);
           }
           
            sr++;
       }
       if(s.length()% k != 0){
           // it has remainder
           if(counter %2 ==0){
               StringBuilder tempRev = new StringBuilder();
               for(int i = s.length()-1; i>= counter*k; i--){
                   tempRev.append(s.charAt(i));
               }
               strResponse.append(tempRev);
           }else{
               strResponse.append(s, k*counter, s.length()); 
           }
           //check if the value needs to be reversed or appended as it is by checking the counter as odd and even

       }
       // remember the case where the abcde
       //abcd
       //ab
       return strResponse.toString();

    }
    public static void main(String args[]){
        Solution541_reverseString revString = new Solution541_reverseString();
        System.out.println(revString.reverseStr("abcd", 3));
    }
}