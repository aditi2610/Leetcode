package StringPractise;

import java.util.Arrays;


public class Solution165_CompareVersionNum {
    public int compareVersion(String version1, String version2) {
        // split both the String by '.'
        // check string lengths, if one is greater than the other put 0's in the end
        // as soon as we find a number greater or smaller than the other,return 0;
  
      int len = version1.split("\\.").length > version2.split("\\.").length? version1.split("\\.").length : version2.split("\\.").length;
      int[] num1 = getArray(version1, len);
      int[] num2 = getArray(version2, len);

        //assuming the strings have same length
        int i =0;
        while(i< len){
            if(num1[i] == num2[i])
                i++;
            else if(num1[i] > num2[i])
                return 1;
            else 
                return -1;
        }
        return 0;
    }

    private int[] getArray(String v, int maxLength){
        int[] result = new int[maxLength];
        Arrays.fill(result, 0);
        String[] arr = v.split("\\.");
        if(arr.length ==0)
            result[0]= Integer.parseInt(v);
        for(int i =0; i< arr.length; i++){
            result[i]= Integer.parseInt(arr[i]);
        }
        return result;
    }

    public static void main(String args[]){

    Solution165_CompareVersionNum cvn = new Solution165_CompareVersionNum();
    System.out.println(cvn.compareVersion("12.2.3", "13"));
        
        
    }
}