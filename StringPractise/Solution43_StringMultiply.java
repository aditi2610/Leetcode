package StringPractise;

public class Solution43_StringMultiply {

    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.equals("0") || num2.equals("0"))
            return "0";

        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        //StringBuilder strBuilder = new StringBuilder();
        int[] values = new int[char1.length  + char2.length];
       for(int i = char1.length -1; i >=0 ; i--){
           for(int j = char2.length -1; j >= 0; j--){
                values[i+j] +=  (char1[i] - '0')*(char2[j] -'0');
           }
       }
       StringBuilder str = new StringBuilder();
       int carry = 0, sum =0;
      for(int k =values.length-1; k>=0;k--){
         sum = values[k] + carry;
         str.append(sum %10);
         carry = sum/10;
      }
      if(carry !=  0)
        str.append(carry);
     int deleteTrails = 0;
    while(deleteTrails < str.length() && str.charAt(deleteTrails) == '0'){
        str.deleteCharAt(deleteTrails);
       // deleteTrails++;
    }
      return str.reverse().toString();
    }

    public static void main(String args[]){
        Solution43_StringMultiply strMult = new Solution43_StringMultiply();
       System.out.println(strMult.multiply("408",
"5"));
    }
}