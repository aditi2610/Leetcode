package Array_my;



public class Solution34_StartAndEndII {

    public int[] searchRange(int[] nums, int target) {

      int[] result ={-1,-1};
      if(nums.length ==0)
      return result;
      int i  =0;
      while(i< nums.length-1 && nums[i]< target){
        i++;
      }
      if(nums[i]== target){
        result[0] = i;
          while(i< nums.length && nums[i]== target)
            i++;
        result[1]= i-1;
      }
      return result;

      
    }
    public static void main(String args[]){

        Solution34_StartAndEndII sol2 = new Solution34_StartAndEndII();
        int[] nums = {2,2};
       int[] result =  sol2.searchRange(nums, 3);
       for(int i: result){
           System.out.print(i + " ");
       }

    }
}