
package July10;

import java.util.TreeSet;

public class Solution532_KDiff{
    public int findPairs(int[] nums, int k) {
            int count =0;
        // sort the array and remove the duplicates
    
        TreeSet<Integer> set = new TreeSet();
        if(k==0){
            return nums.length - set.size();
        }
        for(int i =0; i< nums.length; i++){
            set.add(nums[i]);
        }

       
        Integer[] numshell= new Integer[set.size()];
        set.toArray(numshell);
        for(int j = numshell.length-1; j> 0; j--){
            for (int i = j-1; i>=0; i--){
               if(numshell[j]- numshell[i] == k){
                count++;
                break;
               }
            }
        }
        return count;
    }

    public static void main(String args[]){
        Solution532_KDiff diff = new Solution532_KDiff();
        //int nums[] = {3, 1, 4, 1, 5};
        int nums[] = {1,2,3,4,5};
        System.out.println(diff.findPairs(nums, 1));
    }
}