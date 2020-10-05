package July10;

import java.util.HashMap;
import java.util.Map;

public class Solution532_KDiff1 {
    

    public int findPairs(int[] nums, int k) {
        int count =0;
      if(k<0)
      return 0;
      Map<Integer, Integer> map =new HashMap<>();
      for(int i:nums){
          if(map.containsKey(i)){
            if(k==0 && map.get(i)==1){
                count++;
                map.put(i, 2);
            }
              
            
          }
          else{
              count += map.getOrDefault(i+k, 0);
              count += map.getOrDefault(i-k, 0);
              map.put(i, 1);
          }

      }

      return count;
      
    }

    public static void main(String args[]){
        Solution532_KDiff1 diff1 =new Solution532_KDiff1();
        //int[] row = {1,3,1,4,5};
        //int[] row = { 1, 2, 1, 2 };
        int[] row = { 1, 1, 1, 1, 1 };
        System.out.println( diff1.findPairs(row, 0));
    }
}